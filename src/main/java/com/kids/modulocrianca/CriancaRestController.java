package com.kids.modulocrianca;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.Set;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kids.exception.KidsException;
import com.kids.model.Crianca;
import com.kids.model.Usuario;
import com.kids.modulocrianca.vo.CriancaAtualizaVO;
import com.kids.modulocrianca.vo.CriancaNovoVO;
import com.kids.util.JsonUtil;
import com.kids.util.RestErroVo;
import com.kids.util.RestUtil;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 * 
 */
@RestController
@RequestMapping("/crianca")
public class CriancaRestController {

    @Autowired
    private CriancaService criancaService;




    @CrossOrigin(origins = {"https://kids-web.herokuapp.com"})
    @RequestMapping(method = POST, produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCriancasByUsuario(@Valid @RequestBody(required = true) final Usuario usuario) {
	final Set<Crianca> criancas = this.criancaService.getCriancasByUsuario(usuario);
	final HttpStatus httpStatus = CollectionUtils.isEmpty(criancas) ? HttpStatus.NO_CONTENT : HttpStatus.OK;
	return ResponseEntity.status(httpStatus).body(JsonUtil.convertToJson(criancas));
    }




    @CrossOrigin(origins = {"https://kids-web.herokuapp.com"})
    @RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@Valid @RequestBody(required = true) final CriancaNovoVO criancaNovoVO, final Errors errors) {
	try {
	    if (RestUtil.existeErroNaRequisicao(errors)) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(RestUtil.getErros(errors));
	    } else {
		return ResponseEntity.status(CREATED).body(JsonUtil.convertToJson(this.criancaService.save(criancaNovoVO)));
	    }
	} catch (final KidsException e) {
	    return ResponseEntity.status(CONFLICT).body(new RestErroVo(e.getMessage()));
	}
    }




    @CrossOrigin(origins = {"https://kids-web.herokuapp.com"})
    @RequestMapping(method = PUT, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@Valid @RequestBody(required = true) final CriancaAtualizaVO criancaAtualizaVO, final Errors errors) {
	try {
	    if (RestUtil.existeErroNaRequisicao(errors)) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(RestUtil.getErros(errors));
	    } else {
		return ResponseEntity.status(OK).body(JsonUtil.convertToJson(this.criancaService.update(criancaAtualizaVO)));
	    }
	} catch (final KidsException e) {
	    return ResponseEntity.status(CONFLICT).body(new RestErroVo(e.getMessage()));
	}
    }

}