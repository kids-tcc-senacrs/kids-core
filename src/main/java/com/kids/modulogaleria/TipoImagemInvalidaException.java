package com.kids.modulogaleria;

import com.kids.exception.KidsException;
import com.kids.util.KidsMessageUtil;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 10/2017
 * 
 */
public class TipoImagemInvalidaException extends KidsException {

    private static final long serialVersionUID = 6119388821236980103L;

    public static final String MESSAGE = "message_tipoImagemInvalidaException";





    public TipoImagemInvalidaException() {
	super(KidsMessageUtil.getMessage(MESSAGE));
    }

}