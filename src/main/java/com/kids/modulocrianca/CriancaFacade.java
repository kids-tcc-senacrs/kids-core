package com.kids.modulocrianca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.model.Crianca;
import com.kids.modulocrianca.validate.CriancaInexistenteException;
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





    /**
     * 
     * @param id
     * @return {@link Crianca}
     */
    public Crianca getCriancaById(final Long id) {
	return this.criancaRepository.findCriancaById(id);
    }





    /**
     * 
     * @param id
     * @return {@link Crianca}
     * @throws CriancaInexistenteException
     *             : quando não encontrar uma {@link Crianca} na base de dados.
     */
    public Crianca getBuscarById(final Long id) throws CriancaInexistenteException {
	final Crianca crianca = this.criancaRepository.findCriancaById(id);
	if (crianca == null) {
	    throw new CriancaInexistenteException();
	}
	return crianca;
    }

}