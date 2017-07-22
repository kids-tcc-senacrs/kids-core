package com.kids.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kids.model.Crianca;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 * 
 */
@Repository
public class CriancaRepository {

    @PersistenceContext
    private EntityManager em;





    @Transactional
    public Crianca save(final Crianca crianca) {
	this.em.persist(crianca);
	this.em.flush();
	return crianca;
    }





    @Transactional
    public Crianca update(final Crianca crianca) {
	return this.em.merge(crianca);
    }





    public Crianca find(final Long id) {
	return this.em.find(Crianca.class, id);
    }
}