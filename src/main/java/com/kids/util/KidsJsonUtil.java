package com.kids.util;

import java.io.Serializable;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 01/2017
 *
 */
public class KidsJsonUtil implements Serializable {

    private static final long serialVersionUID = 6645086833069573829L;





    public static <T> String convertToJson(final T entity) {
	try {
	    final ObjectMapper mapper = new ObjectMapper();
	    return mapper.writeValueAsString(entity);
	} catch (final Exception e) {
	    //TODO: ADD LOG
	    System.out.println(e);
	}
	return null;
    }

    //    public static <T> String convertToJson(final T entity) {
    //	final GsonBuilder b = new GsonBuilder();
    //	b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
    //	final Gson gson = b.create();
    //	return gson.toJson(entity);
    //    }

}