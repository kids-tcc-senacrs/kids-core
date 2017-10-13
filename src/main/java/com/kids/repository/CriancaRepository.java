package com.kids.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kids.model.Creche;
import com.kids.model.Crianca;
import com.kids.model.CriancaFamilia;
import com.kids.model.Familia;
import com.kids.model.comparator.CriancaNomeComparator;

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
    public Crianca persist(final Crianca crianca) {
	this.em.persist(crianca);
	this.em.persist(crianca.getPessoa().getEndereco());
	this.em.flush();
	return crianca;
    }





    @Transactional
    public Crianca update(final Crianca crianca) {
	return this.em.merge(crianca);
    }





    public Crianca findCriancaById(final Long id) {
	final Session session = (Session) this.em.getDelegate();
	final DetachedCriteria criteria = DetachedCriteria.forClass(Crianca.class, "crianca");
	criteria.createAlias("crianca.pessoa", "criancaPessoa", JoinType.INNER_JOIN);
	criteria.createAlias("criancaPessoa.endereco", "enderecoCrianca", JoinType.INNER_JOIN);
	criteria.createAlias("crianca.creche", "creche", JoinType.INNER_JOIN);
	criteria.createAlias("creche.pessoa", "crechePessoa", JoinType.INNER_JOIN);
	criteria.createAlias("crechePessoa.endereco", "crecheEndereco", JoinType.LEFT_OUTER_JOIN);
	criteria.createAlias("crianca.contato", "contato", JoinType.INNER_JOIN);
	criteria.createAlias("crianca.alergias", "a", JoinType.LEFT_OUTER_JOIN);
	criteria.createAlias("crianca.medicamentos", "m", JoinType.LEFT_OUTER_JOIN);

	criteria.setFetchMode("crianca.pessoa", FetchMode.SELECT);
	criteria.setFetchMode("criancaPessoa.endereco", FetchMode.SELECT);
	criteria.setFetchMode("crechePessoa.endereco", FetchMode.SELECT);
	criteria.setFetchMode("crianca.creche", FetchMode.SELECT);
	criteria.setFetchMode("crianca.contato", FetchMode.SELECT);
	criteria.setFetchMode("crianca.alergias", FetchMode.SELECT);
	criteria.setFetchMode("crianca.alergias", FetchMode.SELECT);
	criteria.setFetchMode("crianca.medicamentos", FetchMode.SELECT);

	criteria.add(Restrictions.eq("crianca.id", id));
	return (Crianca) criteria.getExecutableCriteria(session).uniqueResult();
    }





    @SuppressWarnings("unchecked")
    public List<Crianca> findCriancasByCreche(final Creche creche) {
	final Session session = (Session) this.em.getDelegate();
	final DetachedCriteria criteria = DetachedCriteria.forClass(Crianca.class, "crianca");
	criteria.createAlias("crianca.pessoa", "criancaPessoa", JoinType.INNER_JOIN);
	criteria.createAlias("criancaPessoa.endereco", "enderecoCrianca", JoinType.INNER_JOIN);
	criteria.createAlias("crianca.creche", "creche", JoinType.INNER_JOIN);
	criteria.createAlias("crianca.contato", "contato", JoinType.INNER_JOIN);
	criteria.createAlias("crianca.alergias", "a", JoinType.LEFT_OUTER_JOIN);
	criteria.createAlias("crianca.medicamentos", "m", JoinType.LEFT_OUTER_JOIN);
	criteria.setFetchMode("crianca.pessoa", FetchMode.SELECT);
	criteria.setFetchMode("criancaPessoa.endereco", FetchMode.SELECT);
	criteria.setFetchMode("crianca.creche", FetchMode.SELECT);
	criteria.setFetchMode("crianca.contato", FetchMode.SELECT);
	criteria.setFetchMode("crianca.alergias", FetchMode.SELECT);
	criteria.setFetchMode("crianca.medicamentos", FetchMode.SELECT);
	criteria.add(Restrictions.eq("creche", creche));
	final Collection<Crianca> result = criteria.getExecutableCriteria(session).list();
	final Set<Crianca> criancas = result.stream().collect(Collectors.toSet());
	final List<Crianca> listCriancas = new ArrayList<>(criancas);
	Collections.sort(listCriancas, new CriancaNomeComparator());
	return this.lazy(listCriancas);
    }





    public Crianca findCriancasByCrecheAndMatricula(final Creche creche, final String matricula) {
	final Session session = (Session) this.em.getDelegate();
	final DetachedCriteria criteria = DetachedCriteria.forClass(Crianca.class);
	criteria.add(Restrictions.eq("creche", creche));
	criteria.add(Restrictions.eq("matricula", matricula));
	return (Crianca) criteria.getExecutableCriteria(session).uniqueResult();
    }





    private List<Crianca> lazy(final List<Crianca> criancas) {
	if (CollectionUtils.isNotEmpty(criancas)) {
	    for (final Crianca crianca : criancas) {
		crianca.getPessoa().getId();
		crianca.getPessoa().getNome();
		crianca.getPessoa().getEndereco();
		crianca.getContato();
		crianca.getCreche();
		crianca.getCreche().getPessoa();
		crianca.getCreche().getPessoa().getNome();
		crianca.getAlergias();
		crianca.getMedicamentos();
	    }
	}
	return criancas;
    }





    @SuppressWarnings("unchecked")
    public List<Crianca> findCriancasByFamiliar(final Familia familia) {
	final Session session = (Session) this.em.getDelegate();
	final DetachedCriteria criteria = DetachedCriteria.forClass(CriancaFamilia.class, "cf");
	criteria.createAlias("cf.familia", "familia");
	criteria.createAlias("cf.crianca", "crianca");
	criteria.createAlias("crianca.pessoa", "criancaPessoa", JoinType.INNER_JOIN);
	criteria.createAlias("criancaPessoa.endereco", "enderecoCrianca", JoinType.INNER_JOIN);
	criteria.createAlias("crianca.contato", "contato", JoinType.INNER_JOIN);
	criteria.createAlias("crianca.creche", "creche", JoinType.INNER_JOIN);
	criteria.createAlias("creche.pessoa", "crechePessoa", JoinType.INNER_JOIN);
	criteria.createAlias("crianca.alergias", "a", JoinType.LEFT_OUTER_JOIN);
	criteria.createAlias("crianca.medicamentos", "m", JoinType.LEFT_OUTER_JOIN);

	criteria.add(Restrictions.eq("cf.familia", familia));
	criteria.setFetchMode("crianca.pessoa", FetchMode.SELECT);
	criteria.setFetchMode("criancaPessoa.endereco", FetchMode.SELECT);
	criteria.setFetchMode("crianca.contato", FetchMode.SELECT);
	criteria.setFetchMode("crianca.creche", FetchMode.SELECT);
	criteria.setFetchMode("creche.pessoa", FetchMode.SELECT);
	criteria.setFetchMode("crianca.alergias", FetchMode.SELECT);
	criteria.setFetchMode("crianca.medicamentos", FetchMode.SELECT);
	criteria.setProjection(Projections.property("cf.crianca"));

	final Collection<Crianca> result = criteria.getExecutableCriteria(session).list();
	final Set<Crianca> criancas = result.stream().collect(Collectors.toSet());
	final List<Crianca> listCriancas = new ArrayList<>(criancas);
	Collections.sort(listCriancas, new CriancaNomeComparator());
	return this.lazy(listCriancas);
    }

}