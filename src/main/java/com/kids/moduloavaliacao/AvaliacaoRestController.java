package com.kids.moduloavaliacao;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kids.moduloavaliacao.vo.AvaliacaoVO;
import com.kids.util.KidsJsonUtil;

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

}