package com.kids.modulocrianca;

import com.kids.exception.KidsException;
import com.kids.util.MessageUtil;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 * 
 */
class CriancaJaCadastradaException extends KidsException {

	private static final long serialVersionUID = 7211135332200411498L;

	private static final String MESSAGE = "message_criancaJaCadastradaException";



	public CriancaJaCadastradaException() {
		super(MessageUtil.getMessage(MESSAGE));
	}
}