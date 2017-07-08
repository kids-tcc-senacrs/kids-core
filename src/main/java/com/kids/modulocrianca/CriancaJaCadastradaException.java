package com.kids.modulocrianca;

import com.kids.exception.KidsException;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 * 
 */
class CriancaJaCadastradaException extends KidsException {

	private static final long serialVersionUID = 7211135332200411498L;



	public CriancaJaCadastradaException() {
		super("A criança já possui cadastro para a matrícula informada");
	}
	
}