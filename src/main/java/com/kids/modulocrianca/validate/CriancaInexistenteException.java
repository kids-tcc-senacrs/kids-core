package com.kids.modulocrianca.validate;

import com.kids.exception.KidsException;
import com.kids.util.KidsMessageUtil;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 *
 */
public class CriancaInexistenteException extends KidsException {

    private static final long serialVersionUID = 4903070745394897715L;

    public final static String MESSAGE = "message_criancaInexistenteException";





    public CriancaInexistenteException() {
	super(KidsMessageUtil.getMessage(MESSAGE));
    }

}