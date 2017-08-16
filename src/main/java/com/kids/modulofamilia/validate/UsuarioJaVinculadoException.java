package com.kids.modulofamilia.validate;

import com.kids.exception.KidsException;
import com.kids.util.KidsMessageUtil;

/**
 * 
 * @author/luciano - lucianortizsilva@gmail.com
 * @since 08/2017
 *
 */
public class UsuarioJaVinculadoException extends KidsException {

    private static final long serialVersionUID = 266651173685175464L;

    public final static String MESSAGE = "message_usuarioJaVinculadoException";





    public UsuarioJaVinculadoException() {
	super(KidsMessageUtil.getMessage(MESSAGE));
    }
}