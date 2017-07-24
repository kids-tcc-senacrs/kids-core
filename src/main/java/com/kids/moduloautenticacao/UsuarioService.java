package com.kids.moduloautenticacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.enumeration.TipoUsuario;
import com.kids.model.Endereco;
import com.kids.model.Usuario;
import com.kids.moduloautenticacao.vo.UsuarioAtualizaVO;
import com.kids.moduloautenticacao.vo.UsuarioNovoVO;
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





    Usuario saveUsuario(final UsuarioNovoVO vo) throws UsuarioJaCadastradoException {
	if (this.usuarioInformadoJaPossuiCadastro(vo.getEmail()))
	    throw new UsuarioJaCadastradoException();
	final Usuario usuario = this.create(vo);
	return this.usuarioRepository.save(usuario);
    }





    Usuario updateUsuario(final UsuarioAtualizaVO vo) throws UsuarioInexistenteException {
	if (!this.usuarioInformadoJaPossuiCadastro(vo.getId())) {
	    throw new UsuarioInexistenteException();
	}
	Usuario usuario = this.usuarioRepository.findUsuarioById(vo.getId());
	usuario = this.usuarioRepository.findByEmail(usuario.getEmail());
	this.update(usuario, vo);
	this.updateEndereco(usuario, vo);
	return usuario;
    }





    Usuario getUserById(final Long id) {
	return this.usuarioRepository.findUsuarioById(id);
    }





    Usuario getUserByEmail(final String email) {
	return this.usuarioRepository.findByEmail(email);
    }





    private void updateEndereco(final Usuario usuario, final UsuarioAtualizaVO vo) {
	if (vo.getPessoa().getEndereco() != null) {
	    if (usuario.getPessoa().getEndereco() == null) {
		usuario.getPessoa().setEndereco(new Endereco());
	    }
	    usuario.getPessoa().getEndereco().setCep(vo.getPessoa().getEndereco().getCep());
	    usuario.getPessoa().getEndereco().setLogradouro(vo.getPessoa().getEndereco().getLogradouro());
	    usuario.getPessoa().getEndereco().setLocalizacao(vo.getPessoa().getEndereco().getLocalizacao());
	}
    }





    private void update(final Usuario usuario, final UsuarioAtualizaVO vo) {
	usuario.setTelefone(vo.getTelefone());
	usuario.setAtivo(vo.isAtivo());
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