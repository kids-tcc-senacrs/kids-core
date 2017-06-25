package com.kids.util;

import org.springframework.validation.Errors;

import com.google.gson.Gson;

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
		final RestErroVo restErroVo = new RestErroVo();
		if (errors.hasErrors()) {
			errors.getAllErrors().forEach(e -> {
				restErroVo.addMessage(e.getDefaultMessage());
			});
		}
		return new Gson().toJson(restErroVo);
	}
	
}