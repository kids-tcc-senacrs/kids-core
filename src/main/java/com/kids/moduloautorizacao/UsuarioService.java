package com.kids.moduloautorizacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.model.Usuario;
import com.kids.repository.UsuarioRepository;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 05/2017
 * 
 */
@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario findUsuarioByEmail(final String email) {
		return this.usuarioRepository.findByEmail(email);
	}

	public void createUsuario(final UsuarioVO usuarioVO) throws UsuarioJaCadastradoException {
		if (this.usuarioJaCadastrado(usuarioVO)) {
			throw new UsuarioJaCadastradoException();
		}
		this.usuarioRepository.save(usuarioVO);
	}

	private boolean usuarioJaCadastrado(final UsuarioVO usuarioVO) {
		final Usuario u = this.findUsuarioByEmail(usuarioVO.getEmail());
		return u == null ? Boolean.TRUE : Boolean.FALSE;
	}

}