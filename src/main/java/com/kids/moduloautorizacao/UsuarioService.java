package com.kids.moduloautorizacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.model.Endereco;
import com.kids.model.Endereco.Estado;
import com.kids.model.Usuario;
import com.kids.model.Usuario.Tipo;
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

	public void createUsuario(final UsuarioVO vo) throws UsuarioJaCadastradoException {
		this.validar(vo);
		final Usuario usuario = this.criarUsuario(vo);
		final Endereco endereco = this.criarEndereco(vo);
		usuario.setEndereco(endereco);
		this.usuarioRepository.save(usuario);
	}

	public Usuario findUsuarioByEmail(final String email) {
		return this.usuarioRepository.findByEmail(email);
	}

	private void validar(UsuarioVO vo) throws UsuarioJaCadastradoException {
		if (this.usuarioInformadoJaPossuiCadastro(vo)) {
			throw new UsuarioJaCadastradoException();
		}
	}

	private Usuario criarUsuario(final UsuarioVO vo) {
		final Usuario usuario = new Usuario();
		usuario.setNome(vo.getNome());
		usuario.setFoto(vo.getFotoUrl());
		usuario.setApelido(vo.getApelido());
		usuario.setEmail(vo.getEmail());
		usuario.setTelefone(vo.getTelefone());
		usuario.setAtivo(Boolean.FALSE);
		usuario.setTipo(Tipo.valueOf(Tipo.class, vo.getTipo()));
		return usuario;
	}

	private Endereco criarEndereco(final UsuarioVO vo) {
		if (this.informouAlgumDadoDoEndereco(vo)) {
			final Endereco endereco = new Endereco();
			endereco.setCep(vo.getEndereco().getCep());
			endereco.setCidade(vo.getEndereco().getCidade());
			endereco.setBairro(vo.getEndereco().getBairro());
			endereco.setEstado(Estado.valueOf(Estado.class, vo.getEndereco().getEstado()));
			endereco.setLogradouro(vo.getEndereco().getLogradouro());
			return endereco;
		}
		return null;
	}

	private boolean informouAlgumDadoDoEndereco(UsuarioVO vo) {
		return vo.getEndereco() != null;
	}

	private boolean usuarioInformadoJaPossuiCadastro(final UsuarioVO usuarioVO) {
		final Usuario u = this.findUsuarioByEmail(usuarioVO.getEmail());
		return u == null ? Boolean.FALSE : Boolean.TRUE;
	}

}