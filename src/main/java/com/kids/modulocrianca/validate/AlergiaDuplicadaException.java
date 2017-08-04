package com.kids.modulocrianca.validate;

import com.kids.exception.KidsException;
import com.kids.util.KidsMessageUtil;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 * 
 */
public class AlergiaDuplicadaException extends KidsException {

	private static final long serialVersionUID = -251317303212996013L;

	public static final String MESSAGE = "message_alergiaDuplicadaException";

	public AlergiaDuplicadaException(final String alergia) {
		super(KidsMessageUtil.getMessage(MESSAGE, alergia));
	}

}