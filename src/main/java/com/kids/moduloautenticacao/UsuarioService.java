package com.kids.moduloautenticacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.enumeration.TipoUsuario;
import com.kids.model.Endereco;
import com.kids.model.Pessoa;
import com.kids.model.Usuario;
import com.kids.moduloautenticacao.vo.UsuarioAtualizaVO;
import com.kids.moduloautenticacao.vo.UsuarioNovoVO;
import com.kids.repository.EnderecoRepository;
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

    @Autowired
    private EnderecoRepository enderecoRepository;





    void saveUsuario(final UsuarioNovoVO vo) throws UsuarioJaCadastradoException {
	if (this.usuarioInformadoJaPossuiCadastro(vo.getEmail()))
	    throw new UsuarioJaCadastradoException();
	final Usuario usuario = this.create(vo);
	this.usuarioRepository.persist(usuario);
    }





    void updateUsuario(final UsuarioAtualizaVO vo) throws UsuarioInexistenteException {
	if (!this.usuarioInformadoJaPossuiCadastro(vo.getId())) {
	    throw new UsuarioInexistenteException();
	}
	final Usuario usuario = this.usuarioRepository.findUsuarioById(vo.getId());
	this.updateEndereco(usuario.getPessoa(), vo);
	this.updateUsuario(usuario, vo);
    }





    Usuario getUsuarioById(final Long id) {
	return this.usuarioRepository.findUsuarioById(id);
    }





    Usuario getUserByEmail(final String email) {
	return this.usuarioRepository.findByEmail(email);
    }





    private void updateEndereco(final Pessoa pessoa, final UsuarioAtualizaVO vo) {
	Endereco endereco = this.getEndereco(pessoa);
	if (endereco == null) {
	    endereco = new Endereco();
	}

	if (vo.getPessoa().getEndereco() != null) {
	    endereco.setPessoa(pessoa);
	    endereco.setLogradouro(vo.getPessoa().getEndereco().getLogradouro());
	    endereco.setLocalizacao(vo.getPessoa().getEndereco().getLocalizacao());
	    endereco.setCep(vo.getPessoa().getEndereco().getCep());
	    this.enderecoRepository.save(endereco);
	}
    }





    private Endereco getEndereco(final Pessoa pessoa) {
	return this.enderecoRepository.findEnderecoByPessoa(pessoa);
    }





    private void updateUsuario(final Usuario usuario, final UsuarioAtualizaVO vo) {
	usuario.setTelefone(vo.getTelefone());
	usuario.setAtivo(vo.isAtivo());
	this.usuarioRepository.update(usuario);
    }





    private Usuario create(final UsuarioNovoVO vo) {
	final Usuario usuario = new Usuario();
	usuario.getPessoa().setNome(vo.getNome());
	usuario.setEmail(vo.getEmail());
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