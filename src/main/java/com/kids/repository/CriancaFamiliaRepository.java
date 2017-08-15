package com.kids.repository;

import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
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





    @SuppressWarnings("unchecked")
    public Set<CriancaFamilia> findByCriancaId(final Long criancaId) {
	final Session session = (Session) this.em.getDelegate();
	final DetachedCriteria criteria = DetachedCriteria.forClass(CriancaFamilia.class, "cf");
	criteria.createAlias("cf.familia", "familia", JoinType.INNER_JOIN);
	criteria.createAlias("cf.usuario", "usuario", JoinType.INNER_JOIN);
	criteria.createAlias("familia.pessoa", "pessoaFamilia", JoinType.INNER_JOIN);
	criteria.setFetchMode("cf.familia", FetchMode.SELECT);
	criteria.setFetchMode("cf.usuario", FetchMode.SELECT);
	criteria.setFetchMode("familia.pessoa", FetchMode.SELECT);
	criteria.add(Restrictions.eq("cf.crianca.id", criancaId));
	return (Set<CriancaFamilia>) criteria.getExecutableCriteria(session).list().stream().collect(Collectors.toSet());
    }





    public CriancaFamilia findByCriancaFamiliaId(final Long criancaFamiliaId) {
	final Session session = (Session) this.em.getDelegate();
	final DetachedCriteria criteria = DetachedCriteria.forClass(CriancaFamilia.class);
	criteria.add(Restrictions.eq("id", criancaFamiliaId));
	return (CriancaFamilia) criteria.getExecutableCriteria(session).uniqueResult();
    }





    @Transactional
    public void remove(final CriancaFamilia criancaFamilia) {
	this.em.remove(criancaFamilia);
    }

}