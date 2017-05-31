package com.kids.moduloautorizacao;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.kids.exception.KidsException;
import com.kids.model.Usuario;
import com.kids.moduloautorizacao.vo.UsuarioAtualizaVO;
import com.kids.moduloautorizacao.vo.UsuarioNovoVO;
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
		final Usuario usuario = this.usuarioService.findUserByEmail(email);
		final String gson = new Gson().toJson(usuario);
		final HttpStatus httpStatus = usuario == null ? HttpStatus.NO_CONTENT : HttpStatus.OK;
		return ResponseEntity.status(httpStatus).body(gson);
	}



	@RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createUser(@Valid @RequestBody(required = true) final UsuarioNovoVO usuario, final Errors errors) {
		try {
			if (RestUtil.existeErroNaRequisicao(errors)) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(RestUtil.getErros(errors));
			} else {
				this.usuarioService.createUsuario(usuario);
				return new ResponseEntity<Void>(CREATED);
			}
		} catch (final KidsException e) {
			return ResponseEntity.status(CONFLICT).body(e.getMessage());
		}
	}



	@RequestMapping(method = PUT, consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateUser(@Valid @RequestBody(required = true) final UsuarioAtualizaVO usuario, final Errors errors) {
		try {
			if (RestUtil.existeErroNaRequisicao(errors)) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(RestUtil.getErros(errors));
			} else {
				this.usuarioService.updateUsuario(usuario);
				return new ResponseEntity<Void>(HttpStatus.OK);
			}
		} catch (final KidsException e) {
			return ResponseEntity.status(CONFLICT).body(e.getMessage());
		}
	}
}