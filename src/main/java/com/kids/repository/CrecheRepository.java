package com.kids.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
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
		final Session session = (Session) this.em.getDelegate();
		final DetachedCriteria criteria = DetachedCriteria.forClass(Creche.class, "creche");
		criteria.createAlias("creche.pessoa", "pessoa", JoinType.INNER_JOIN);
		criteria.setFetchMode("creche.pessoa", FetchMode.SELECT);
		criteria.add(Restrictions.eq("creche.id", id));
		return (Creche) criteria.getExecutableCriteria(session).uniqueResult();
	}

	public Creche findCrecheByUsuario(final Usuario usuario) {
		final Session session = (Session) this.em.getDelegate();
		final DetachedCriteria criteria = DetachedCriteria.forClass(Creche.class, "creche");
		criteria.createAlias("creche.pessoa", "pessoa", JoinType.INNER_JOIN);
		criteria.setFetchMode("creche.pessoa", FetchMode.SELECT);
		criteria.add(Restrictions.eq("creche.pessoa", usuario.getPessoa()));
		return (Creche) criteria.getExecutableCriteria(session).uniqueResult();
	}

}