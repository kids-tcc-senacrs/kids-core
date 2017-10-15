package com.kids.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kids.model.Galeria;

@Repository
public class GaleriaRepository {

    @PersistenceContext
    private EntityManager em;





    @Transactional
    public void persist(final Galeria galeria) {
	this.em.persist(galeria);
    }

}