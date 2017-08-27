package com.kids.modulodiarioescolar.validate;

import com.kids.exception.KidsException;
import com.kids.util.KidsMessageUtil;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 08/2017
 * 
 */
public class DiarioInexistenteException extends KidsException {

    private static final long serialVersionUID = 4166356270063412352L;

    public static final String MESSAGE = "message_diarioInexistenteException";





    public DiarioInexistenteException() {
	super(KidsMessageUtil.getMessage(MESSAGE));
    }
}