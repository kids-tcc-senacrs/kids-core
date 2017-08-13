package com.kids.modulofamilia;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kids.exception.KidsException;
import com.kids.modulofamilia.vo.FamiliaVO;
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
		return ResponseEntity.status(CREATED).build();
	    }
	} catch (final KidsException e) {
	    return ResponseEntity.status(CONFLICT).body(new RestErroVo(e.getMessage()));
	}
    }





    @RequestMapping(method = PUT, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@Valid @RequestBody(required = true) final FamiliaVO vo, final Errors errors) {
	try {
	    if (KidsRestUtil.existeErroNaRequisicao(errors)) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(KidsRestUtil.getErros(errors));
	    } else {
		this.familiaService.atualizar(vo);
		return ResponseEntity.status(OK).build();
	    }
	} catch (final KidsException e) {
	    return ResponseEntity.status(CONFLICT).body(new RestErroVo(e.getMessage()));
	}
    }
}