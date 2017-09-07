package com.kids.moduloeventos.validate;

import com.kids.exception.KidsException;
import com.kids.util.KidsMessageUtil;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 09/2017
 * 
 */
public class EventoInexistenteException extends KidsException {

    private static final long serialVersionUID = 5478545470932314L;

    public static final String MESSAGE = "message_eventoInexistenteException";





    EventoInexistenteException() {
	super(KidsMessageUtil.getMessage(MESSAGE));
    }
}