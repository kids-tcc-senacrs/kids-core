package com.kids.moduloautenticacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.exception.KidsException;
import com.kids.model.Pessoa;
import com.kids.model.Usuario;
import com.kids.moduloautenticacao.build.BuildUsuario;
import com.kids.moduloautenticacao.dto.UsuarioAtualizaDTO;
import com.kids.moduloautenticacao.dto.UsuarioNovoDTO;
import com.kids.moduloautenticacao.validate.ValidateUsuario;
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





    void saveUsuario(final UsuarioNovoDTO vo) throws KidsException {
	new ValidateUsuario(vo, usuarioRepository);
	final BuildUsuario build = new BuildUsuario(vo);
	this.usuarioRepository.persist(build.getUsuario());
    }





    void updateUsuario(final UsuarioAtualizaDTO vo) throws KidsException {
	new ValidateUsuario(vo, usuarioRepository);
	final BuildUsuario build = new BuildUsuario(vo, this.usuarioRepository, this.enderecoRepository);
	this.usuarioRepository.update(build.getUsuario());
    }





    Usuario getUsuarioById(final Long id) {
	return this.usuarioRepository.findUsuarioById(id);
    }





    Usuario getUserByEmail(final String email) {
	return this.usuarioRepository.findByEmail(email);
    }





    public Usuario getUsuarioByPessoa(final Pessoa pessoa) {
	return this.usuarioRepository.findUsuarioByPessoa(pessoa);
    }

}