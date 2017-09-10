package com.kids.moduloaviso.validate;

import com.kids.exception.KidsException;
import com.kids.util.KidsMessageUtil;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 09/2017
 * 
 */
public class AvisoInexistenteException extends KidsException {

    private static final long serialVersionUID = 316245624017352312L;

    public static final String MESSAGE = "message_avisoInexistenteException";





    public AvisoInexistenteException() {
	super(KidsMessageUtil.getMessage(MESSAGE));
    }

}