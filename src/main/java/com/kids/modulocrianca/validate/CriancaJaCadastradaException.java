package com.kids.modulocrianca.validate;

import com.kids.exception.KidsException;
import com.kids.util.KidsMessageUtil;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 * 
 */
public class CriancaJaCadastradaException extends KidsException {

    private static final long serialVersionUID = 7211135332200411498L;

    public static final String MESSAGE = "message_criancaJaCadastradaException";





    public CriancaJaCadastradaException() {
	super(KidsMessageUtil.getMessage(MESSAGE));
    }
}