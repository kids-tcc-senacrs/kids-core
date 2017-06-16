package com.kids.moduloautorizacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.model.Endereco;
import com.kids.model.Usuario;
import com.kids.moduloautorizacao.vo.UsuarioAtualizaVO;
import com.kids.moduloautorizacao.vo.UsuarioNovoVO;
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



	void createUsuario(final UsuarioNovoVO vo) throws UsuarioJaCadastradoException {
		if (this.usuarioInformadoJaPossuiCadastro(vo.getEmail()))
			throw new UsuarioJaCadastradoException();
		final Usuario usuario = this.criarUsuario(vo);
		final Endereco endereco = this.criarEndereco(vo);
		usuario.setEndereco(endereco);
		this.usuarioRepository.save(usuario);
	}



	void updateUsuario(final UsuarioAtualizaVO vo) throws UsuarioInexistenteException {
		if (!this.usuarioInformadoJaPossuiCadastro(vo.getId()))
			throw new UsuarioInexistenteException();
		final Usuario usuario = this.usuarioRepository.findUsuarioById(vo.getId());
		this.atualizarUsuario(usuario, vo);
		this.atualizarEndereco(usuario, vo);
		this.usuarioRepository.update(usuario);
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
			usuario.getEndereco().setCidade(vo.getEndereco().getCidade());
			usuario.getEndereco().setEstado(vo.getEndereco().getEstado());
			usuario.getEndereco().setLogradouro(vo.getEndereco().getLogradouro());
			usuario.getEndereco().setBairro(vo.getEndereco().getBairro());
		}
	}



	private void atualizarUsuario(final Usuario usuario, UsuarioAtualizaVO vo) {
		usuario.setNome(vo.getNome());
		usuario.setApelido(vo.getApelido());
		usuario.setTelefone(vo.getTelefone());
		usuario.setAtivo(vo.isAtivo());
	}



	private Usuario criarUsuario(final UsuarioNovoVO vo) {
		final Usuario usuario = new Usuario();
		usuario.setNome(vo.getNome());
		usuario.setApelido(vo.getApelido());
		usuario.setEmail(vo.getEmail());
		usuario.setTelefone(vo.getTelefone());
		usuario.setAtivo(Boolean.FALSE);
		usuario.setTipo(vo.getTipo());
		return usuario;
	}



	private Endereco criarEndereco(final UsuarioNovoVO vo) {
		if (this.informouAlgumDadoDoEndereco(vo)) {
			final Endereco endereco = new Endereco();
			endereco.setCep(vo.getEndereco().getCep());
			endereco.setCidade(vo.getEndereco().getCidade());
			endereco.setBairro(vo.getEndereco().getBairro());
			endereco.setEstado(vo.getEndereco().getEstado());
			endereco.setLogradouro(vo.getEndereco().getLogradouro());
			return endereco;
		}
		return null;
	}



	private boolean informouAlgumDadoDoEndereco(UsuarioNovoVO vo) {
		return vo.getEndereco() != null;
	}



	private boolean usuarioInformadoJaPossuiCadastro(final String email) {
		return this.usuarioRepository.findByEmail(email) == null ? Boolean.FALSE : Boolean.TRUE;
	}



	private boolean usuarioInformadoJaPossuiCadastro(final Long id) {
		return this.usuarioRepository.findUsuarioById(id) == null ? Boolean.FALSE : Boolean.TRUE;
	}
}