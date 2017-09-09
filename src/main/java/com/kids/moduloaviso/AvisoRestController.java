package com.kids.moduloaviso;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kids.exception.KidsException;
import com.kids.moduloaviso.dto.AvisoDTO;
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
@RequestMapping("/aviso")
public class AvisoRestController {

    @Autowired
    private AvisoService avisoService;





    @RequestMapping(method = GET, path = "/{usuarioId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAvisosNaoExpirados(@PathVariable(required = true) final Long usuarioId) {
	return ResponseEntity.status(HttpStatus.OK).body(KidsJsonUtil.convertToJson(this.avisoService.getAvisosNaoExpirados(usuarioId)));
    }





    @RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@Valid @RequestBody(required = true) final AvisoDTO dto, final Errors errors) {
	try {
	    if (KidsRestUtil.existeErroNaRequisicao(errors)) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(KidsRestUtil.getErros(errors));
	    } else {

		this.avisoService.save(dto);

		return ResponseEntity.status(CREATED).build();
	    }
	} catch (final KidsException e) {
	    return ResponseEntity.status(CONFLICT).body(new RestErroVo(e.getMessage()));
	}
    }

}