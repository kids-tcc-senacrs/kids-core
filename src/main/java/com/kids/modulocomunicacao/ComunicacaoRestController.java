package com.kids.modulocomunicacao;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kids.modulocomunicacao.dto.ComunicacaoDTO;
import com.kids.modulocomunicacao.vo.ComunicacaoVO;
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
@RequestMapping("/comunicacao")
public class ComunicacaoRestController {

    @Autowired
    private ComunicacaoService comunicadoService;





    @RequestMapping(method = GET, path = "/{crecheId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getComunicacoesByCreche(@PathVariable(required = true) final Long crecheId) {

	final List<ComunicacaoVO> comunicacoes = this.comunicadoService.getComunicacoesByCreche(crecheId);

	final HttpStatus httpStatus = CollectionUtils.isEmpty(comunicacoes) ? HttpStatus.NO_CONTENT : HttpStatus.OK;

	return ResponseEntity.status(httpStatus).body(KidsJsonUtil.convertToJson(comunicacoes));
    }





    @RequestMapping(method = GET, path = "/{usuarioId}/{familiar}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getComunicacoesByUsuario(@PathVariable(required = true) final Long usuarioId, @PathVariable(required = true) final boolean familiar) {

	List<ComunicacaoVO> comunicacoes = new ArrayList<>();

	if (familiar) {
	    comunicacoes.addAll(this.comunicadoService.getComunicacoesByUsuarioFamiliar(usuarioId));
	}

	final HttpStatus httpStatus = CollectionUtils.isEmpty(comunicacoes) ? HttpStatus.NO_CONTENT : HttpStatus.OK;

	return ResponseEntity.status(httpStatus).body(KidsJsonUtil.convertToJson(comunicacoes));
    }





    @RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@Valid @RequestBody(required = true) final ComunicacaoDTO dto, final Errors errors) {
	try {
	    if (KidsRestUtil.existeErroNaRequisicao(errors)) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(KidsRestUtil.getErros(errors));
	    } else {
		this.comunicadoService.save(dto);
		return ResponseEntity.status(CREATED).build();
	    }
	} catch (final Exception e) {
	    return ResponseEntity.status(CONFLICT).body(new RestErroVo(e.getMessage()));
	}
    }





    @RequestMapping(method = PUT, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@Valid @RequestBody(required = true) final ComunicacaoDTO dto, final Errors errors) {
	try {
	    if (KidsRestUtil.existeErroNaRequisicao(errors)) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(KidsRestUtil.getErros(errors));
	    } else {
		this.comunicadoService.update(dto);
		return ResponseEntity.status(OK).build();
	    }
	} catch (final Exception e) {
	    return ResponseEntity.status(CONFLICT).body(new RestErroVo(e.getMessage()));
	}
    }
}