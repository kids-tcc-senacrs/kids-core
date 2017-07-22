package com.kids.modulocrianca;

import com.kids.exception.KidsException;
import com.kids.util.MessageUtil;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 * 
 */
class AlergiaDuplicadaException extends KidsException {

    private static final long serialVersionUID = -251317303212996013L;

    private static final String MESSAGE = "message_alergiaDuplicadaException";





    public AlergiaDuplicadaException(final String alergia) {
	super(MessageUtil.getMessage(MESSAGE, alergia));
    }

}