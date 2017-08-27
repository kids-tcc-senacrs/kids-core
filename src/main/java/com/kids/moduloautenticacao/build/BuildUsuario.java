package com.kids.moduloautenticacao.build;

import com.kids.model.Endereco;
import com.kids.model.Usuario;
import com.kids.moduloautenticacao.dto.UsuarioAtualizaDTO;
import com.kids.moduloautenticacao.dto.UsuarioNovoDTO;
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





    public BuildUsuario(final UsuarioNovoDTO vo) {
	this.build(vo);
    }





    public BuildUsuario(final UsuarioAtualizaDTO vo, final UsuarioRepository usuarioRepository, final EnderecoRepository enderecoRepository) {
	this.usuarioRepository = usuarioRepository;
	this.enderecoRepository = enderecoRepository;
	this.build(vo);
    }





    private void build(final UsuarioNovoDTO vo) {
	this.usuario.getPessoa().setNome(vo.getNome());
	this.usuario.getPessoa().setEndereco(null);
	this.usuario.setEmail(vo.getEmail());
	this.usuario.setTipo(vo.getTipo());
	this.usuario.setAtivo(vo.getAtivo() == null ? Boolean.FALSE : vo.getAtivo());
    }





    private void build(final UsuarioAtualizaDTO vo) {
	this.usuario = this.usuarioRepository.findUsuarioById(vo.getId());
	this.usuario.setTelefone(vo.getTelefone());
	this.usuario.setAtivo(vo.isAtivo());
	this.updateEndereco(vo);
    }





    private void updateEndereco(final UsuarioAtualizaDTO vo) {
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