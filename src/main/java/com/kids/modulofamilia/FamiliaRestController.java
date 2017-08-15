package com.kids.modulofamilia;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Set;

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

import com.kids.exception.KidsException;
import com.kids.model.CriancaFamilia;
import com.kids.modulofamilia.vo.FamiliaVO;
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
@RequestMapping("/familia")
public class FamiliaRestController {

    @Autowired
    private FamiliaService familiaService;





    @RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@Valid @RequestBody(required = true) final FamiliaVO vo, final Errors errors) {
	try {
	    if (KidsRestUtil.existeErroNaRequisicao(errors)) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(KidsRestUtil.getErros(errors));
	    } else {

		this.familiaService.save(vo);

		return ResponseEntity.status(CREATED).body(KidsJsonUtil.convertToJson(this.familiaService.getByCriancaId(vo.getCriancaId())));
	    }
	} catch (final KidsException e) {
	    return ResponseEntity.status(CONFLICT).body(new RestErroVo(e.getMessage()));
	}
    }





    @RequestMapping(method = DELETE, path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable(required = true) final Long id) {
	try {
	    this.familiaService.delete(id);
	} catch (final KidsException e) {
	    return ResponseEntity.status(CONFLICT).body(new RestErroVo(e.getMessage()));
	}
	return ResponseEntity.status(HttpStatus.OK).build();
    }





    @RequestMapping(method = GET, path = "/{criancaId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByCrianca(@PathVariable(required = true) final Long criancaId) {
	final Set<CriancaFamilia> criancaFamilias = this.familiaService.getByCriancaId(criancaId);
	final HttpStatus httpStatus = CollectionUtils.isEmpty(criancaFamilias) ? HttpStatus.NO_CONTENT : HttpStatus.OK;
	return ResponseEntity.status(httpStatus).body(KidsJsonUtil.convertToJson(criancaFamilias));

    }

}