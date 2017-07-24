package com.kids.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.kids.model.Creche;
import com.kids.model.Usuario;

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





    public Creche findCrecheByUsuario(final Usuario u) {
	final Session session = (Session) this.em.getDelegate();
	final DetachedCriteria criteria = DetachedCriteria.forClass(Creche.class);
	criteria.add(Restrictions.eq("pessoa", u.getPessoa()));
	return (Creche) criteria.getExecutableCriteria(session).uniqueResult();
    }

}