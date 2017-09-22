package com.kids.modulocomunicacao.validate;

import com.kids.exception.KidsException;
import com.kids.util.KidsMessageUtil;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 09/2017
 * 
 */
public class TipoUsuarioNaoPodeCriarComunicacaoException extends KidsException {

    private static final long serialVersionUID = 47518395212545454L;

    public static final String MESSAGE = "message_tipoUsuarioNaoPodeCriarComunicacaoException";





    TipoUsuarioNaoPodeCriarComunicacaoException() {
	super(KidsMessageUtil.getMessage(MESSAGE));
    }
}