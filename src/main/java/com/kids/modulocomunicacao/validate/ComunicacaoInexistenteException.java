package com.kids.modulocomunicacao.validate;

import com.kids.exception.KidsException;
import com.kids.util.KidsMessageUtil;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 09/2017
 * 
 */
public class ComunicacaoInexistenteException extends KidsException {

    private static final long serialVersionUID = 6546464844444255L;

    public static final String MESSAGE = "message_comunicacaoInexistenteException";





    ComunicacaoInexistenteException() {
	super(KidsMessageUtil.getMessage(MESSAGE));
    }
}