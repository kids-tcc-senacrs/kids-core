package com.kids.modulocomunicacao.validate;

import com.kids.exception.KidsException;
import com.kids.util.KidsMessageUtil;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 09/2017
 * 
 */
public class CrecheJaRespondeuException extends KidsException {

    private static final long serialVersionUID = 8487066819507340128L;

    public static final String MESSAGE = "message_crecheJaRespondeuException";





    CrecheJaRespondeuException() {
	super(KidsMessageUtil.getMessage(MESSAGE));
    }
}