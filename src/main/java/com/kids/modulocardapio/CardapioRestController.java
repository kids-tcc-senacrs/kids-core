package com.kids.modulocardapio;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kids.model.Cardapio;
import com.kids.modulocardapio.vo.CardapioVO;
import com.kids.util.KidsJsonUtil;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 10/2017
 * 
 */
@RestController
@RequestMapping("/cardapio")
public class CardapioRestController {

    @Autowired
    private CardapioService cardapioService;





    @RequestMapping(method = GET, path = "/{crecheId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCardapios(@PathVariable(required = true) final Long crecheId) {
	final List<CardapioVO> cardapios = this.cardapioService.getCardapiosByCreche(crecheId);
	final HttpStatus httpStatus = CollectionUtils.isEmpty(cardapios) ? HttpStatus.NO_CONTENT : HttpStatus.OK;
	return ResponseEntity.status(httpStatus).body(KidsJsonUtil.convertToJson(cardapios));
    }





    @RequestMapping(method = DELETE, path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable(required = true) final Long id) {
	final Cardapio cardapio = this.cardapioService.getByid(id);
	final HttpStatus httpStatus = cardapio == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
	if (cardapio != null) {
	    this.cardapioService.delete(cardapio);
	}
	return ResponseEntity.status(httpStatus).build();
    }

}