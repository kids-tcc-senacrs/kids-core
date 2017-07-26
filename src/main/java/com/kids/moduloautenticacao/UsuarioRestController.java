package com.kids.moduloautenticacao;

import static com.kids.util.KidsConstant.URL_WEB_DEV;
import static com.kids.util.KidsConstant.URL_WEB_PROD;
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

import com.google.gson.Gson;
import com.kids.exception.KidsException;
import com.kids.model.Endereco;
import com.kids.model.Usuario;
import com.kids.moduloautenticacao.vo.UsuarioAtualizaVO;
import com.kids.moduloautenticacao.vo.UsuarioNovoVO;
import com.kids.util.JsonUtil;
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





    @CrossOrigin(origins = { URL_WEB_DEV, URL_WEB_PROD }, allowCredentials = "true", exposedHeaders = { "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials" }, allowedHeaders = {
            "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method", "Access-Control-Request-Headers" })
    @RequestMapping(method = GET, path = "/{email:.+}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserByEmail(@PathVariable(required = true) final String email) {
	final Usuario usuario = this.usuarioService.getUserByEmail(email);
	if (usuario != null && usuario.getPessoa().getEndereco() == null) {
	    usuario.getPessoa().setEndereco(new Endereco());
	}
	final HttpStatus httpStatus = usuario == null ? HttpStatus.NO_CONTENT : HttpStatus.OK;
	return ResponseEntity.status(httpStatus).body(JsonUtil.convertToJson(usuario));
    }





    @CrossOrigin(origins = { URL_WEB_DEV, URL_WEB_PROD }, allowCredentials = "true", exposedHeaders = { "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials" }, allowedHeaders = {
            "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method", "Access-Control-Request-Headers" })
    @RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@Valid @RequestBody(required = true) final UsuarioNovoVO usuario, final Errors errors) {
	try {
	    if (RestUtil.existeErroNaRequisicao(errors)) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(RestUtil.getErros(errors));
	    } else {
		return ResponseEntity.status(CREATED).body(new Gson().toJson(this.usuarioService.saveUsuario(usuario)));
	    }
	} catch (final KidsException e) {
	    return ResponseEntity.status(CONFLICT).body(new RestErroVo(e.getMessage()));
	}
    }





    @CrossOrigin(origins = { URL_WEB_DEV, URL_WEB_PROD }, allowCredentials = "true", exposedHeaders = { "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials" }, allowedHeaders = {
            "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method", "Access-Control-Request-Headers" })
    @RequestMapping(method = PUT, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@Valid @RequestBody(required = true) final UsuarioAtualizaVO usuario, final Errors errors) {
	try {
	    if (RestUtil.existeErroNaRequisicao(errors)) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(RestUtil.getErros(errors));
	    } else {
		return ResponseEntity.status(OK).body(JsonUtil.convertToJson(this.usuarioService.updateUsuario(usuario)));
	    }
	} catch (final KidsException e) {
	    return ResponseEntity.status(CONFLICT).body(new RestErroVo(e.getMessage()));
	}
    }

}