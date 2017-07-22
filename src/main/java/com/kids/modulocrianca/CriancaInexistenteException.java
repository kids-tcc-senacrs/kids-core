package com.kids.modulocrianca;

import com.kids.exception.KidsException;
import com.kids.util.MessageUtil;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 *
 */
class CriancaInexistenteException extends KidsException {

    private static final long serialVersionUID = 4903070745394897715L;

    private final static String MESSAGE = "message_criancaInexistenteException";





    public CriancaInexistenteException() {
	super(MessageUtil.getMessage(MESSAGE));
    }

}