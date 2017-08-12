package com.kids.repository;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
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
    public Set<Crianca> findCriancasByCreche(final Creche creche) {
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

	return this.lazy(criancas);
    }





    public Crianca findCriancasByCrecheAndMatricula(final Creche creche, final String matricula) {
	final Session session = (Session) this.em.getDelegate();
	final DetachedCriteria criteria = DetachedCriteria.forClass(Crianca.class);
	criteria.add(Restrictions.eq("creche", creche));
	criteria.add(Restrictions.eq("matricula", matricula));
	return (Crianca) criteria.getExecutableCriteria(session).uniqueResult();
    }





    private Set<Crianca> lazy(final Set<Crianca> criancas) {
	if (CollectionUtils.isNotEmpty(criancas)) {
	    for (final Crianca crianca : criancas) {
		crianca.getPessoa();
		crianca.getPessoa().getEndereco();
		crianca.getContato();
		crianca.getCreche();
		crianca.getAlergias();
		crianca.getMedicamentos();
	    }
	}
	return criancas;
    }

}