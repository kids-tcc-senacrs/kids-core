package com.kids.moduloautorizacao;

import com.kids.exception.KidsException;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 05/2017
 * 
 */
class UsuarioInexistenteException extends KidsException {

	private static final long serialVersionUID = 5478545470932314L;



	UsuarioInexistenteException() {
		super("O usuário informado 'NÃO' possui cadastro!");
	}
	
}