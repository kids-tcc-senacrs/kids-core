package com.kids.moduloautenticacao.build;

import com.kids.enumeration.TipoUsuario;
import com.kids.model.Endereco;
import com.kids.model.Usuario;
import com.kids.moduloautenticacao.vo.UsuarioAtualizaVO;
import com.kids.moduloautenticacao.vo.UsuarioNovoVO;
import com.kids.repository.EnderecoRepository;
import com.kids.repository.UsuarioRepository;

/**
 * 
 * @author ortiz - lucianoortizsilva@gmail.com
 * @since 08/2017
 *
 */
public class BuildUsuario {

	private UsuarioRepository usuarioRepository;

	private EnderecoRepository enderecoRepository;

	private Usuario usuario = new Usuario();

	public BuildUsuario(final UsuarioNovoVO vo) {
		this.build(vo);
	}

	public BuildUsuario(final UsuarioAtualizaVO vo, final UsuarioRepository usuarioRepository, final EnderecoRepository enderecoRepository) {
		this.usuarioRepository = usuarioRepository;
		this.enderecoRepository = enderecoRepository;
		this.build(vo);
	}

	private void build(final UsuarioNovoVO vo) {
		this.usuario.getPessoa().setNome(vo.getNome());
		this.usuario.setEmail(vo.getEmail());
		this.usuario.setTipo(vo.getTipo());
		if (TipoUsuario.CRECHE.equals(vo.getTipo())) {
			this.usuario.setAtivo(Boolean.TRUE);
		} else if (TipoUsuario.FAMILIAR.equals(vo.getTipo())) {
			this.usuario.setAtivo(Boolean.FALSE);
		} else {
			throw new UnsupportedOperationException("[KIDS] - Operação não suportada pelo sistema");
		}
	}

	private void build(final UsuarioAtualizaVO vo) {
		this.usuario = this.usuarioRepository.findUsuarioById(vo.getId());
		this.usuario.setTelefone(vo.getTelefone());
		this.usuario.setAtivo(vo.isAtivo());
		this.updateEndereco(vo);
	}

	private void updateEndereco(final UsuarioAtualizaVO vo) {
		Endereco endereco = this.enderecoRepository.findEnderecoByPessoa(this.usuario.getPessoa());
		if (endereco == null) {
			endereco = new Endereco();
		}
		if (vo.getPessoa().getEndereco() != null) {
			endereco.setPessoa(this.usuario.getPessoa());
			endereco.setLogradouro(vo.getPessoa().getEndereco().getLogradouro());
			endereco.setLocalizacao(vo.getPessoa().getEndereco().getLocalizacao());
			endereco.setCep(vo.getPessoa().getEndereco().getCep());
			this.enderecoRepository.save(endereco);
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}
}