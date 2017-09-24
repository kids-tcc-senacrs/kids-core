package com.kids.moduloaviso.validate;

import com.kids.exception.KidsException;
import com.kids.util.KidsMessageUtil;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 09/2017
 * 
 */
public class DataExpiracaoInvalidaException extends KidsException {

    private static final long serialVersionUID = -902508512290462613L;

    public static final String MESSAGE = "message_dataExpiracaoInvalidaException";





    public DataExpiracaoInvalidaException() {
	super(KidsMessageUtil.getMessage(MESSAGE));
    }

}