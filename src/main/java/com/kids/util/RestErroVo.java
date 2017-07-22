package com.kids.util;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 06/2017
 *
 */
public class RestErroVo implements Serializable {

    private static final long serialVersionUID = -4698748822672578829L;

    private ArrayList<String> messages = new ArrayList<>();





    public RestErroVo(final String message) {
	this.addMessage(message);
    }





    public RestErroVo() {
	super();
    }





    public ArrayList<String> getMessages() {
	return messages;
    }





    public void addMessage(final String message) {
	this.messages.add(message);
    }

}