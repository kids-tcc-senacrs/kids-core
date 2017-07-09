package com.kids.moduloautenticacao;

import com.kids.exception.KidsException;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 05/2017
 * 
 */
class UsuarioJaCadastradoException extends KidsException {

	private static final long serialVersionUID = 4751839521260932314L;



	UsuarioJaCadastradoException() {
		super("O usuário informado já possui cadastro!");
	}
}