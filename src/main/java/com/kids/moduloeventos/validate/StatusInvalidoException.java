package com.kids.moduloeventos.validate;

import com.kids.exception.KidsException;
import com.kids.util.KidsMessageUtil;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 09/2017
 *
 */
class StatusInvalidoException extends KidsException {

    private static final long serialVersionUID = -14154205568077240L;





    public StatusInvalidoException(final String message) {
	super(KidsMessageUtil.getMessage(message));
    }

}