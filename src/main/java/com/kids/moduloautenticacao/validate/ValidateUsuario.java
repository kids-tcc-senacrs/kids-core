package com.kids.moduloautenticacao.validate;

import com.kids.exception.KidsException;
import com.kids.moduloautenticacao.vo.UsuarioAtualizaVO;
import com.kids.moduloautenticacao.vo.UsuarioNovoVO;
import com.kids.repository.UsuarioRepository;

/**
 * 
 * @author ortiz - lucianoortizsilva@GMAIL.COM
 * @since 08/2017
 *
 */
public class ValidateUsuario {

	private UsuarioRepository usuarioRepository;

	public ValidateUsuario(final UsuarioNovoVO vo, final UsuarioRepository usuarioRepository) throws KidsException {
		this.usuarioRepository = usuarioRepository;
		this.validate(vo);
	}

	public ValidateUsuario(final UsuarioAtualizaVO vo, final UsuarioRepository usuarioRepository) throws KidsException {
		this.usuarioRepository = usuarioRepository;
		this.validate(vo);
	}

	private void validate(final UsuarioNovoVO vo) throws KidsException {
		this.validarCadastroDuplicado(vo);
	}

	private void validate(final UsuarioAtualizaVO vo) throws KidsException {
		this.validarUsuarioInexistente(vo);
	}

	private void validarUsuarioInexistente(final UsuarioAtualizaVO vo) throws UsuarioInexistenteException {
		if (!this.usuarioInformadoJaPossuiCadastro(vo.getId())) {
			throw new UsuarioInexistenteException();
		}
	}

	private void validarCadastroDuplicado(final UsuarioNovoVO vo) throws UsuarioJaCadastradoException {
		if (this.usuarioInformadoJaPossuiCadastro(vo.getEmail()))
			throw new UsuarioJaCadastradoException();
	}

	private boolean usuarioInformadoJaPossuiCadastro(final String email) {
		return this.usuarioRepository.findByEmail(email) == null ? Boolean.FALSE : Boolean.TRUE;
	}

	private boolean usuarioInformadoJaPossuiCadastro(final Long id) {
		return this.usuarioRepository.findUsuarioById(id) == null ? Boolean.FALSE : Boolean.TRUE;
	}

}