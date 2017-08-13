package com.kids.modulofamilia.validate;

import com.kids.exception.KidsException;
import com.kids.util.KidsMessageUtil;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 08/2017
 *
 */
public class TipoUsuarioInvalidoException extends KidsException {

    private static final long serialVersionUID = 266651173685175464L;

    public final static String MESSAGE = "message_tipoUsuarioInvalidoException";





    public TipoUsuarioInvalidoException() {
	super(KidsMessageUtil.getMessage(MESSAGE));
    }

}