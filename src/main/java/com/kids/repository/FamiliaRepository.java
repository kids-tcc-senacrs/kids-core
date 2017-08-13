package com.kids.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.kids.model.Familia;
import com.kids.model.Usuario;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 08/2017
 * 
 */
@Repository
public class FamiliaRepository {

    @PersistenceContext
    private EntityManager em;





    public Familia findFamiliarByUsuario(final Usuario usuario) {
	final Session session = (Session) this.em.getDelegate();
	final DetachedCriteria criteria = DetachedCriteria.forClass(Familia.class, "f");
	criteria.createAlias("f.pessoa", "pessoa", JoinType.INNER_JOIN);
	criteria.setFetchMode("f.pessoa", FetchMode.SELECT);
	criteria.add(Restrictions.eq("f.pessoa", usuario.getPessoa()));
	return (Familia) criteria.getExecutableCriteria(session).uniqueResult();
    }

}