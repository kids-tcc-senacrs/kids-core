package com.kids.modulocreche;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.model.Creche;
import com.kids.model.Usuario;
import com.kids.repository.CrecheRepository;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 * 
 */
@Service
public class CrecheService {

    @Autowired
    private CrecheRepository crecheRepository;





    Creche getById(final Long id) {
	return this.crecheRepository.find(id);
    }





    public Creche getCrecheByUsuario(final Usuario usuario) {
	return crecheRepository.findCrecheByUsuario(usuario);
    }

}