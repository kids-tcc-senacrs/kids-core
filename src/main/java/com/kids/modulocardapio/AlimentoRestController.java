package com.kids.modulocardapio;

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

import com.kids.modulocardapio.vo.AlimentoVO;
import com.kids.util.KidsJsonUtil;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 10/2017
 * 
 */
@RestController
@RequestMapping("/alimento")
public class AlimentoRestController {

    @Autowired
    private CardapioService cardapioService;





    @RequestMapping(method = GET, path = "/{cardapioId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAlimentos(@PathVariable(required = true) final Long cardapioId) {
	final List<AlimentoVO> alimentos = this.cardapioService.getAlimentosByCardapioId(cardapioId);
	final HttpStatus httpStatus = CollectionUtils.isEmpty(alimentos) ? HttpStatus.NO_CONTENT : HttpStatus.OK;
	return ResponseEntity.status(httpStatus).body(KidsJsonUtil.convertToJson(alimentos));
    }

}