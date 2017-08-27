package com.kids.modulodiarioescolar.validate;

import com.kids.enumeration.DiarioTipo;
import com.kids.exception.KidsException;
import com.kids.util.KidsMessageUtil;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 08/2017
 * 
 */
public class DiarioDuplicadoException extends KidsException {

    private static final long serialVersionUID = 4166356270063412352L;

    public static final String MESSAGE = "message_diarioDuplicadoException";





    public DiarioDuplicadoException(final Long crecheId, final Long criancaId, final DiarioTipo tipo) {
	super(KidsMessageUtil.getMessage(MESSAGE, crecheId, criancaId, tipo));
    }

}