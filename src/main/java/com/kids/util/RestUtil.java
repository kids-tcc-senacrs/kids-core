package com.kids.util;

import org.springframework.validation.Errors;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 05/2017
 * 
 */
public class RestUtil {

	public static boolean existeErroNaRequisicao(final Errors errors) {
		if (errors.hasErrors()) {
			return true;
		}
		return false;
	}



	public static String getErros(final Errors errors) {
		final StringBuilder msgErros = new StringBuilder();
		if (errors.hasErrors()) {
			errors.getAllErrors().forEach(e -> {
				msgErros.append(e.getDefaultMessage()).append("\n");
			});
		}
		return msgErros.toString();
	}
}