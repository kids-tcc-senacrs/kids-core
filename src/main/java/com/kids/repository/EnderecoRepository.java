package com.kids.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.kids.model.Endereco;
import com.kids.model.Pessoa;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 * 
 */
@Repository
public class EnderecoRepository {

    @PersistenceContext
    private EntityManager em;





    public Endereco find(final Long id) {
	return this.em.find(Endereco.class, id);
    }





    public Endereco findEnderecoByPessoa(final Pessoa pessoa) {
	final Session session = (Session) this.em.getDelegate();
	final DetachedCriteria criteria = DetachedCriteria.forClass(Endereco.class);
	criteria.add(Restrictions.eq("pessoa", pessoa));
	return (Endereco) criteria.getExecutableCriteria(session).uniqueResult();
    }





    @Transactional
    public void save(final Endereco endereco) {
	this.em.persist(endereco);
    }

}