package com.kids.moduloeventos;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kids.exception.KidsException;
import com.kids.moduloeventos.dto.EventoDTO;
import com.kids.moduloeventos.vo.EventoVO;
import com.kids.util.KidsJsonUtil;
import com.kids.util.KidsRestUtil;
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





    @RequestMapping(method = GET, path = "/{usuarioId}/{emAberto}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getEventosByUsuarioFamiliar(@PathVariable(required = true) final Long usuarioId, @PathVariable(required = true) final boolean emAberto) {
	try {
	    final List<EventoVO> eventos = new ArrayList<>();
	    if (emAberto) {
		eventos.addAll(this.eventoService.getEventosByUsuarioFamiliarEmAberto(usuarioId));
	    } else {
		eventos.addAll(this.eventoService.getEventosByUsuarioFamiliarCancelados(usuarioId));
	    }
	    return ResponseEntity.status(HttpStatus.OK).body(KidsJsonUtil.convertToJson(eventos));
	} catch (final KidsException e) {
	    return ResponseEntity.status(CONFLICT).body(new RestErroVo(e.getMessage()));
	}
    }





    @RequestMapping(method = GET, path = "/{usuarioId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getEventosByUsuarioCreche(@PathVariable(required = true) final Long usuarioId) {
	try {
	    final List<EventoVO> eventos = this.eventoService.getEventosByUsuarioCreche(usuarioId);
	    return ResponseEntity.status(HttpStatus.OK).body(KidsJsonUtil.convertToJson(eventos));
	} catch (final KidsException e) {
	    return ResponseEntity.status(CONFLICT).body(new RestErroVo(e.getMessage()));
	}
    }





    @RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@Valid @RequestBody(required = true) final EventoDTO dto, final Errors errors) {
	try {
	    if (KidsRestUtil.existeErroNaRequisicao(errors)) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(KidsRestUtil.getErros(errors));
	    } else {
		this.eventoService.save(dto);
		return ResponseEntity.status(CREATED).build();
	    }
	} catch (final KidsException e) {
	    return ResponseEntity.status(CONFLICT).body(new RestErroVo(e.getMessage()));
	}
    }





    @RequestMapping(method = PUT, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@Valid @RequestBody(required = true) final EventoDTO dto, final Errors errors) {
	try {
	    if (KidsRestUtil.existeErroNaRequisicao(errors)) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(KidsRestUtil.getErros(errors));
	    } else {

		this.eventoService.update(dto);

		return ResponseEntity.status(CREATED).build();
	    }
	} catch (final KidsException e) {
	    return ResponseEntity.status(CONFLICT).body(new RestErroVo(e.getMessage()));
	}
    }

}