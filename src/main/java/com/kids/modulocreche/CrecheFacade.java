package com.kids.modulocreche;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.model.Creche;
import com.kids.model.Usuario;

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





    public Creche getCreche(final Long id) {
	return this.crecheService.getById(id);
    }





    public Creche getCrecheByUsuario(final Usuario u) {
	return this.crecheService.getCrecheByUsuario(u);
    }

}