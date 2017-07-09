package com.kids.modulocrianca;

import com.kids.exception.KidsException;
import com.kids.util.MessageUtil;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 * 
 */
public class CrecheInexistenteException extends KidsException {

	private static final long serialVersionUID = 4166356270063412352L;

	private static final String MESSAGE = "message_crecheInexistenteException";



	public CrecheInexistenteException(final Long id) {
		super(MessageUtil.getMessage(MESSAGE, id));
	}
	
}