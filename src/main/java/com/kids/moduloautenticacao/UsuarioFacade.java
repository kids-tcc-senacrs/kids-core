package com.kids.moduloautenticacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.enumeration.TipoUsuario;
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



	public Usuario getUsuario(final Long usuarioId, final TipoUsuario tipoUsuario) {
		return this.usuarioRepository.findUsuarioByIdAndTipo(usuarioId, tipoUsuario);
	}
}