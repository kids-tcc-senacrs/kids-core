package com.kids.moduloautorizacao;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kids.model.Usuario;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 05/2017
 * 
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioRestController {

	private UsuarioService usuarioService;

	@Autowired
	public UsuarioRestController(final UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}

	@ResponseStatus(CREATED)
	@RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE)
	public Resource<Usuario> createUsuario(@RequestBody Usuario usuario) {
		return new Resource<>(usuarioService.createUsuario(usuario));
	}

}