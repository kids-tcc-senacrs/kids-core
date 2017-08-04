package com.kids.moduloautenticacao;

import com.kids.exception.KidsException;
import com.kids.util.KidsMessageUtil;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 05/2017
 * 
 */
class UsuarioInexistenteException extends KidsException {

    private static final long serialVersionUID = 5478545470932314L;

    private static final String MESSAGE = "message_usuarioInexistenteException";





    UsuarioInexistenteException() {
	super(KidsMessageUtil.getMessage(MESSAGE));
    }
}