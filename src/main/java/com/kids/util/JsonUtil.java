package com.kids.util;

import java.io.Serializable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 01/2017
 *
 */
public class JsonUtil implements Serializable {

	private static final long serialVersionUID = 6645086833069573829L;



	public static <T> String convertToJson(final T entity) {
		final GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		final Gson gson = b.create();
		return gson.toJson(entity);
	}
}