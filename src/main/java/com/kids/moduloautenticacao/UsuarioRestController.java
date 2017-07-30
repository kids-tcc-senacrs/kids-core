package com.kids.moduloautenticacao;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kids.exception.KidsException;
import com.kids.model.Usuario;
import com.kids.moduloautenticacao.vo.UsuarioAtualizaVO;
import com.kids.moduloautenticacao.vo.UsuarioNovoVO;
import com.kids.util.JsonUtil;
import com.kids.util.KidsConstant;
import com.kids.util.RestErroVo;
import com.kids.util.RestUtil;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 05/2017
 * 
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioRestController {

    @Autowired
    private UsuarioService usuarioService;





    @RequestMapping(method = GET, path = "/{email:.+}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserByEmail(@PathVariable(required = true) final String email) {
	final Usuario usuario = this.usuarioService.getUserByEmail(email);
	final HttpStatus httpStatus = usuario == null ? HttpStatus.NO_CONTENT : HttpStatus.OK;
	return ResponseEntity.status(httpStatus)//
	        .header("Access-Control-Allow-Origin", KidsConstant.URL_WEB_PROD)//
	        .body(JsonUtil.convertToJson(usuario));//
    }





    @CrossOrigin(origins = { KidsConstant.URL_WEB_DEV, KidsConstant.URL_WEB_PROD })
    @RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@Valid @RequestBody(required = true) final UsuarioNovoVO usuario, final Errors errors) {
	try {
	    if (RestUtil.existeErroNaRequisicao(errors)) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(RestUtil.getErros(errors));
	    } else {
		this.usuarioService.saveUsuario(usuario);
		return ResponseEntity.status(CREATED).build();
	    }
	} catch (final KidsException e) {
	    return ResponseEntity.status(CONFLICT).body(new RestErroVo(e.getMessage()));
	}
    }





    @CrossOrigin(origins = { KidsConstant.URL_WEB_DEV, KidsConstant.URL_WEB_PROD })
    @RequestMapping(method = PUT, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@Valid @RequestBody(required = true) final UsuarioAtualizaVO usuario, final Errors errors) {
	try {
	    if (RestUtil.existeErroNaRequisicao(errors)) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(RestUtil.getErros(errors));
	    } else {
		this.usuarioService.updateUsuario(usuario);
		return ResponseEntity.status(OK).build();
	    }
	} catch (final KidsException e) {
	    return ResponseEntity.status(CONFLICT).body(new RestErroVo(e.getMessage()));
	}
    }

}