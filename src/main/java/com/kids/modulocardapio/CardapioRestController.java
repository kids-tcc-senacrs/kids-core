package com.kids.modulocardapio;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
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
import com.kids.model.Cardapio;
import com.kids.modulocardapio.dto.CardapioDTO;
import com.kids.modulocardapio.vo.CardapioVO;
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





    @RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@Valid @RequestBody(required = true) final CardapioDTO dto, final Errors errors) {
	try {
	    if (KidsRestUtil.existeErroNaRequisicao(errors)) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(KidsRestUtil.getErros(errors));
	    } else {
		this.cardapioService.save(dto);
	    }
	} catch (final KidsException e) {
	    return ResponseEntity.status(CONFLICT).body(new RestErroVo(e.getMessage()));
	}
	return ResponseEntity.status(CREATED).build();
    }

}