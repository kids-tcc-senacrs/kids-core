package com.kids.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kids.model.CriancaFamilia;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 08/2017
 * 
 */
@Repository
public class CriancaFamiliaRepository {

    @PersistenceContext
    private EntityManager em;





    @Transactional
    public void persist(final CriancaFamilia criancaFamilia) {
	this.em.persist(criancaFamilia);
    }

}