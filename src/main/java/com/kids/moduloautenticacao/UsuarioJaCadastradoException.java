package com.kids.moduloautenticacao;

import com.kids.exception.KidsException;
import com.kids.util.KidsMessageUtil;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 05/2017
 * 
 */
class UsuarioJaCadastradoException extends KidsException {

    private static final long serialVersionUID = 4751839521260932314L;

    private static final String MESSAGE = "message_usuarioJaCadastradoException";





    UsuarioJaCadastradoException() {
	super(KidsMessageUtil.getMessage(MESSAGE));
    }
}