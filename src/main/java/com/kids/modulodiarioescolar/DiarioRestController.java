package com.kids.modulodiarioescolar;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

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

import com.kids.enumeration.DiarioTipo;
import com.kids.modulodiarioescolar.dto.DiarioDTO;
import com.kids.modulodiarioescolar.vo.DiarioVO;
import com.kids.util.KidsJsonUtil;
import com.kids.util.KidsRestUtil;
import com.kids.util.RestErroVo;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 08/2017
 * 
 */
@RestController
@RequestMapping("/diario")
public class DiarioRestController {

    @Autowired
    private DiarioService diarioService;





    @RequestMapping(method = GET, path = "/{crecheId}/{tipo}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getDiarios(@PathVariable(required = true) final Integer crecheId, @PathVariable(required = true) final DiarioTipo tipo) {
	final List<DiarioVO> diarios = this.diarioService.getDiarios(crecheId, tipo);
	return ResponseEntity.status(HttpStatus.OK).body(KidsJsonUtil.convertToJson(diarios));//
    }





    @RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@Valid @RequestBody(required = true) final List<DiarioDTO> dtos, final Errors errors) {
	try {
	    if (KidsRestUtil.existeErroNaRequisicao(errors)) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(KidsRestUtil.getErros(errors));
	    } else {

		this.diarioService.save(dtos);

		return ResponseEntity.status(OK).body(KidsJsonUtil.convertToJson(this.diarioService.getDiarios(dtos.get(0).getCrecheId().intValue(), dtos.get(0).getTipo())));
	    }
	} catch (final Exception e) {
	    return ResponseEntity.status(CONFLICT).body(new RestErroVo(e.getMessage()));
	}
    }

}