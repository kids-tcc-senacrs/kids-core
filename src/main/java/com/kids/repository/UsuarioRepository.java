package com.kids.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kids.enumeration.TipoUsuario;
import com.kids.model.Creche;
import com.kids.model.Endereco;
import com.kids.model.Familia;
import com.kids.model.Pessoa;
import com.kids.model.Usuario;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 05/2017
 * 
 */
@Repository
public class UsuarioRepository {

    @PersistenceContext
    private EntityManager em;





    public Usuario findByEmail(final String email) {
	final Session session = (Session) this.em.getDelegate();
	final DetachedCriteria criteria = DetachedCriteria.forClass(Usuario.class, "u");
	criteria.createAlias("u.pessoa", "pessoa", JoinType.INNER_JOIN);
	criteria.createAlias("pessoa.endereco", "endereco", JoinType.LEFT_OUTER_JOIN);
	criteria.setFetchMode("u.pessoa", FetchMode.SELECT);
	criteria.setFetchMode("pessoa.endereco", FetchMode.SELECT);
	criteria.add(Restrictions.eq("u.email", email));
	final Usuario u = (Usuario) criteria.getExecutableCriteria(session).uniqueResult();
	return loadToCamposObrigatoriosNoJson(u);
    }





    @Transactional
    public void persist(final Usuario usuario) {
	this.em.persist(usuario);
	if (TipoUsuario.CRECHE.equals(usuario.getTipo())) {
	    this.em.persist(new Creche(usuario.getPessoa()));
	} else if (TipoUsuario.FAMILIAR.equals(usuario.getTipo())) {
	    this.em.persist(new Familia(usuario.getPessoa()));
	}
    }





    @Transactional
    public void update(final Usuario usuario) {
	this.em.merge(usuario);
    }





    public Usuario findUsuarioById(final Long id) {
	return this.em.getReference(Usuario.class, id);
    }





    private Usuario loadToCamposObrigatoriosNoJson(final Usuario u) {
	if (u != null) {
	    u.getPessoa();
	    if (u.getPessoa().getEndereco() == null) {
		u.getPessoa().setEndereco(new Endereco());
	    }
	}
	return u;
    }





    public Usuario findUsuarioByPessoa(final Pessoa pessoa) {
	final Session session = (Session) this.em.getDelegate();
	final DetachedCriteria criteria = DetachedCriteria.forClass(Usuario.class, "u");
	criteria.createAlias("u.pessoa", "pessoa", JoinType.INNER_JOIN);
	criteria.setFetchMode("u.pessoa", FetchMode.SELECT);
	criteria.add(Restrictions.eq("u.pessoa", pessoa));
	return (Usuario) criteria.getExecutableCriteria(session).uniqueResult();
    }

}