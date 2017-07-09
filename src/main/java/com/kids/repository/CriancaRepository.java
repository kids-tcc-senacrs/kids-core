package com.kids.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
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



	public Crianca findByCrecheIdAndMatricula(final Long crecheId, final String matricula) {
		try {
			final String hql = "select crianca from Crianca crianca inner join fetch crianca.creches as creche where crianca.matricula= :matricula and creche.id= :crecheId";
			final Query query = this.em.createQuery(hql, Crianca.class);
			query.setParameter("matricula", StringUtils.trim(matricula));
			query.setParameter("crecheId", crecheId);
			return (Crianca) query.getSingleResult();
		} catch (final Exception e) {
			return null;
		}
	}



	@Transactional
	public Crianca save(final Crianca crianca) {
		this.em.persist(crianca);
		this.em.flush();
		return crianca;
	}
}