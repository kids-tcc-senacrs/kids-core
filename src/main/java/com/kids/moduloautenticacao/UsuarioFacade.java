package com.kids.moduloautenticacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.exception.KidsException;
import com.kids.model.Pessoa;
import com.kids.model.Usuario;
import com.kids.moduloautenticacao.vo.UsuarioNovoVO;

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





    public Usuario getUsuarioByEmail(final String email) {
	return this.usuarioService.getUserByEmail(email);
    }





    public void cadastrar(final UsuarioNovoVO vo) throws KidsException {
	this.usuarioService.saveUsuario(vo);
    }





    public Usuario getUsuarioByPessoa(final Pessoa pessoa) {
	return this.usuarioService.getUsuarioByPessoa(pessoa);
    }

}