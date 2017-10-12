package com.kids.moduloavaliacao;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kids.exception.KidsException;
import com.kids.moduloavaliacao.dto.AvaliacaoDTO;
import com.kids.moduloavaliacao.vo.AvaliacaoVO;
import com.kids.util.KidsJsonUtil;
import com.kids.util.KidsRestUtil;
import com.kids.util.RestErroVo;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 10/2017
 * 
 */
@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoRestController {

    @Autowired
    private AvaliacaoService avaliacaoService;





    @RequestMapping(method = GET, path = "/{criancaId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAvaliacoes(@PathVariable(required = true) final Long criancaId) {

	final List<AvaliacaoVO> avaliacoes = this.avaliacaoService.getAvaliacoes(criancaId);

	final HttpStatus httpStatus = CollectionUtils.isEmpty(avaliacoes) ? HttpStatus.NO_CONTENT : HttpStatus.OK;

	return ResponseEntity.status(httpStatus).body(KidsJsonUtil.convertToJson(avaliacoes));
    }





    @RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@Valid @RequestBody(required = true) final AvaliacaoDTO dto, final Errors errors) {
	try {
	    if (KidsRestUtil.existeErroNaRequisicao(errors)) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(KidsRestUtil.getErros(errors));
	    } else {
		this.avaliacaoService.save(dto);
	    }
	} catch (final KidsException e) {
	    return ResponseEntity.status(CONFLICT).body(new RestErroVo(e.getMessage()));
	}
	return ResponseEntity.status(CREATED).build();
    }

}