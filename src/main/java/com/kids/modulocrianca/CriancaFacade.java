package com.kids.modulocrianca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.model.Crianca;
import com.kids.repository.CriancaRepository;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 08/2017
 * 
 */
@Service
public class CriancaFacade {

    @Autowired
    private CriancaRepository criancaRepository;





    public Crianca getCriancaById(final Long id) {
	return this.criancaRepository.findCriancaById(id);
    }
}