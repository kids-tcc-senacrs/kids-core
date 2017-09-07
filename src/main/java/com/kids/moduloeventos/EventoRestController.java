package com.kids.moduloeventos;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kids.exception.KidsException;
import com.kids.moduloeventos.vo.EventoVO;
import com.kids.util.KidsJsonUtil;
import com.kids.util.RestErroVo;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 09/2017
 * 
 */
@RestController
@RequestMapping("/evento")
public class EventoRestController {

    @Autowired
    private EventoService eventoService;





    @RequestMapping(method = GET, path = "/{usuarioId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getEventosByUsuarioFamiliar(@PathVariable(required = true) final Long usuarioId) {
	try {
	    final List<EventoVO> eventos = this.eventoService.getEventosByUsuarioFamiliar(usuarioId);
	    return ResponseEntity.status(HttpStatus.OK).body(KidsJsonUtil.convertToJson(eventos));
	} catch (final KidsException e) {
	    return ResponseEntity.status(CONFLICT).body(new RestErroVo(e.getMessage()));
	}
    }

}