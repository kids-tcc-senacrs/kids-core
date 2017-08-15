package com.kids.modulofamilia;

import com.kids.exception.KidsException;
import com.kids.util.KidsMessageUtil;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 08/2017
 *
 */
public class FamiliarInexistenteException extends KidsException {

    private static final long serialVersionUID = 3945359064863818511L;

    public final static String MESSAGE = "message_familiarInexistenteException";





    public FamiliarInexistenteException() {
	super(KidsMessageUtil.getMessage(MESSAGE));
    }
}