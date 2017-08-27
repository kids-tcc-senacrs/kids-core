package com.kids.modulocreche;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.model.Creche;
import com.kids.model.Usuario;
import com.kids.modulocrianca.validate.CrecheInexistenteException;

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





    /**
     * 
     * @param id
     * @return {@link Creche}
     * @throws CrecheInexistenteException
     *             : quando não encontrar uma {@link Creche} na base dados.
     */
    public Creche buscarCreche(final Long id) throws CrecheInexistenteException {
	final Creche creche = this.crecheService.getById(id);
	if (creche == null) {
	    throw new CrecheInexistenteException();
	}
	return creche;
    }





    public Creche getCrecheByUsuario(final Usuario u) {
	return this.crecheService.getCrecheByUsuario(u);
    }

}