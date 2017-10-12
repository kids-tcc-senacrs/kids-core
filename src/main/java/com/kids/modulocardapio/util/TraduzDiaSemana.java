package com.kids.modulocardapio.util;

import java.io.Serializable;

/**
 * 
 * @author luciano
 *
 */
public class TraduzDiaSemana implements Serializable {

    private static final long serialVersionUID = 432556672617739865L;





    public static String traduzir(final String diaSemana) {
	if (diaSemana.trim().equalsIgnoreCase("SUNDAY")) {
	    return "DOMINGO";
	} else if (diaSemana.trim().equalsIgnoreCase("MONDAY")) {
	    return "SEGUNDA-FEIRA";
	} else if (diaSemana.trim().equalsIgnoreCase("TUESDAY")) {
	    return "TERCA-FEIRA";
	} else if (diaSemana.trim().equalsIgnoreCase("WEDNESDAY")) {
	    return "QUARTA-FEIRA";
	} else if (diaSemana.trim().equalsIgnoreCase("THURSDAY")) {
	    return "QUINTA-FEIRA";
	} else if (diaSemana.trim().equalsIgnoreCase("FRIDAY")) {
	    return "SEXTA-FEIRA";

	} else {
	    return "SÁBADO";
	}
    }

}