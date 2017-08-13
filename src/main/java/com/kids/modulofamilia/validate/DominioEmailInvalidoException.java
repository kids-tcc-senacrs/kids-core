package com.kids.modulofamilia.validate;

import com.kids.exception.KidsException;
import com.kids.util.KidsMessageUtil;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 08/2017
 *
 */
class DominioEmailInvalidoException extends KidsException {

    private static final long serialVersionUID = 3945359064863818511L;

    public final static String MESSAGE = "message_dominioEmailInvalidoException";





    public DominioEmailInvalidoException() {
	super(KidsMessageUtil.getMessage(MESSAGE));
    }

}