package com.kids.modulocreche;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.model.Creche;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 * 
 */
@Service
public class CrecheFacade {

	@Autowired
	private CrecheService crecheService;



	public Creche get(final Long id) {
		return this.crecheService.getById(id);
	}
}
