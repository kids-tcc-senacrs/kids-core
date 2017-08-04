package com.kids.repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kids.model.Creche;
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

	@SuppressWarnings("unchecked")
	public Set<Crianca> findCriancasByCreche(final Creche creche) {
		final Set<Crianca> criancasbYCreches = new HashSet<>();
		final Session session = (Session) this.em.getDelegate();
		final DetachedCriteria criteria = DetachedCriteria.forClass(Crianca.class);
		criteria.add(Restrictions.eq("creche", creche));
		final Collection<Crianca> result = criteria.getExecutableCriteria(session).list();
		final Set<Crianca> criancas = result.stream().collect(Collectors.toSet());
		this.lazy(criancas);
		return criancasbYCreches;
	}

	public Crianca findCriancasByCrecheAndMatricula(final Creche creche, final String matricula) {
		final Session session = (Session) this.em.getDelegate();
		final DetachedCriteria criteria = DetachedCriteria.forClass(Crianca.class);
		criteria.add(Restrictions.eq("creche", creche));
		criteria.add(Restrictions.eq("matricula", matricula));
		return (Crianca) criteria.getExecutableCriteria(session).uniqueResult();
	}

	private void lazy(final Set<Crianca> criancasbYCreches) {
		if (CollectionUtils.isNotEmpty(criancasbYCreches)) {
			for (final Crianca crianca : criancasbYCreches) {
				if (crianca.getContato() != null) {
					crianca.getContato().getId();
					crianca.getContato().getEmail();
					crianca.getContato().getFoneOutro();
					crianca.getContato().getResponsavel();
					crianca.getContato().getFonePrincipal();
				}
			}
		}
	}

}