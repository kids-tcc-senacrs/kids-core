package com.kids.moduloeventos.validate;

import com.kids.exception.KidsException;
import com.kids.util.KidsMessageUtil;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 09/2017
 *
 */
class TipoUsuarioInvalidoException extends KidsException {

    private static final long serialVersionUID = 6964782622875268384L;

    public final static String MESSAGE = "message_com.kids.moduloeventos_tipoUsuarioInvalidoException";





    public TipoUsuarioInvalidoException() {
	super(KidsMessageUtil.getMessage(MESSAGE));
    }

}