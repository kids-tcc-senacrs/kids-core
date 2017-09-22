package com.kids.moduloautenticacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.exception.KidsException;
import com.kids.model.Pessoa;
import com.kids.model.Usuario;
import com.kids.moduloautenticacao.dto.UsuarioNovoDTO;
import com.kids.moduloautenticacao.validate.UsuarioInexistenteException;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 * 
 */
@Service
public class UsuarioFacade {

    @Autowired
    private UsuarioService usuarioService;





    public Usuario getUsuarioById(final Long id) {
	return this.usuarioService.getUsuarioById(id);
    }





    /**
     * 
     * @param id
     *            id do usuario
     * 
     * @return {@link Usuario}
     * 
     * @throws UsuarioInexistenteException
     */
    public Usuario buscarUsuarioById(final Long id) throws UsuarioInexistenteException {
	final Usuario usuario = this.usuarioService.getUsuarioById(id);
	if (usuario == null) {
	    throw new UsuarioInexistenteException();
	}
	return usuario;
    }





    public Usuario getUsuarioByEmail(final String email) {
	return this.usuarioService.getUserByEmail(email);
    }





    public void cadastrar(final UsuarioNovoDTO vo) throws KidsException {
	this.usuarioService.saveUsuario(vo);
    }





    public Usuario getUsuarioByPessoa(final Pessoa pessoa) {
	return this.usuarioService.getUsuarioByPessoa(pessoa);
    }

}