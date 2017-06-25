package com.kids.moduloautorizacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.enumeration.TipoUsuario;
import com.kids.model.Endereco;
import com.kids.model.Usuario;
import com.kids.repository.UsuarioRepository;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 05/2017
 * 
 */
@Service
class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;



	Usuario createUsuario(final UsuarioNovoVO vo) throws UsuarioJaCadastradoException {
		if (this.usuarioInformadoJaPossuiCadastro(vo.getEmail()))
			throw new UsuarioJaCadastradoException();
		final Usuario usuario = this.criarUsuario(vo);
		return this.usuarioRepository.save(usuario);
	}



	Usuario updateUsuario(final UsuarioAtualizaVO vo) throws UsuarioInexistenteException {
		if (!this.usuarioInformadoJaPossuiCadastro(vo.getId()))
			throw new UsuarioInexistenteException();
		final Usuario usuario = this.usuarioRepository.findUsuarioById(vo.getId());
		this.atualizarUsuario(usuario, vo);
		this.atualizarEndereco(usuario, vo);
		return this.usuarioRepository.update(usuario);
	}



	Usuario findUserByEmail(final String email) {
		return this.usuarioRepository.findByEmail(email);
	}



	private void atualizarEndereco(Usuario usuario, UsuarioAtualizaVO vo) {
		if (vo.getEndereco() != null) {
			if (usuario.getEndereco() == null) {
				usuario.setEndereco(new Endereco());
			}
			usuario.getEndereco().setCep(vo.getEndereco().getCep());
			usuario.getEndereco().setLogradouro(vo.getEndereco().getLogradouro());
			usuario.getEndereco().setLocalizacao(vo.getEndereco().getLocalizacao());
		}
	}



	private void atualizarUsuario(final Usuario usuario, final UsuarioAtualizaVO vo) {
		usuario.setTelefone(vo.getTelefone());
		usuario.setAtivo(vo.isAtivo());
	}



	private Usuario criarUsuario(final UsuarioNovoVO vo) {
		final Usuario usuario = new Usuario();
		usuario.setNome(vo.getNome());
		usuario.setEmail(vo.getEmail());
		usuario.setTelefone(vo.getTelefone());
		usuario.setTipo(vo.getTipo());
		if (TipoUsuario.CRECHE.equals(vo.getTipo())) {
			usuario.setAtivo(Boolean.TRUE);
		} else {
			usuario.setAtivo(Boolean.FALSE);
		}
		return usuario;
	}



	private boolean usuarioInformadoJaPossuiCadastro(final String email) {
		return this.usuarioRepository.findByEmail(email) == null ? Boolean.FALSE : Boolean.TRUE;
	}



	private boolean usuarioInformadoJaPossuiCadastro(final Long id) {
		return this.usuarioRepository.findUsuarioById(id) == null ? Boolean.FALSE : Boolean.TRUE;
	}
	
}