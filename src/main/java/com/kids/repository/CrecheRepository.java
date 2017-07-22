package com.kids.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.kids.model.Creche;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 * 
 */
@Repository
public class CrecheRepository {

    @PersistenceContext
    private EntityManager em;





    public Creche find(final Long id) {
	return this.em.find(Creche.class, id);
    }
}