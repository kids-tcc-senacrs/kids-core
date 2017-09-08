package com.kids.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kids.model.Aviso;

@Repository
public class AvisoRepository {

    @PersistenceContext
    private EntityManager em;





    @Transactional
    public void persist(Aviso aviso) {
	this.em.persist(aviso);
    }





    @SuppressWarnings("unchecked")
    public List<Aviso> findAllNaoExpirados() {
	final Session session = (Session) this.em.getDelegate();
	final DetachedCriteria criteria = DetachedCriteria.forClass(Aviso.class, "aviso");
	criteria.add(Restrictions.gt("aviso.dtExpiracao", new Date()));
	return criteria.getExecutableCriteria(session).list();
    }

}