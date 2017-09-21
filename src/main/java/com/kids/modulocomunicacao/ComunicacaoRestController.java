package com.kids.modulocomunicacao;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kids.modulocomunicacao.vo.ComunicacaoVO;
import com.kids.util.KidsJsonUtil;

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

}