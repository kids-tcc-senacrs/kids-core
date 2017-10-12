package com.kids.modulocardapio;

import com.kids.exception.KidsException;
import com.kids.util.KidsMessageUtil;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 10/2017
 * 
 */
public class CardapioDuplicadoException extends KidsException {

    private static final long serialVersionUID = -1823545244812426643L;

    public static final String MESSAGE = "message_cardapioDuplicadoException";





    public CardapioDuplicadoException() {
	super(KidsMessageUtil.getMessage(MESSAGE));
    }

}