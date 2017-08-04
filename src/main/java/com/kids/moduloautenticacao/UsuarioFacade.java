package com.kids.moduloautenticacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.model.Usuario;
import com.kids.repository.UsuarioRepository;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 * 
 */
@Service
public class UsuarioFacade {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario getUsuarioById(final Long id) {
		return this.usuarioRepository.findUsuarioById(id);
	}
}