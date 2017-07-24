package com.kids.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kids.enumeration.TipoUsuario;
import com.kids.model.Creche;
import com.kids.model.Familia;
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
	criteria.setFetchMode("u.pessoa", FetchMode.SELECT);
	criteria.add(Restrictions.eq("u.email", email));
	return (Usuario) criteria.getExecutableCriteria(session).uniqueResult();
    }





    @Transactional
    public Usuario save(final Usuario usuario) {
	this.em.persist(usuario);
	if (TipoUsuario.CRECHE.equals(usuario.getTipo())) {
	    this.em.persist(new Creche(usuario.getPessoa()));
	} else if (TipoUsuario.FAMILIAR.equals(usuario.getTipo())) {
	    this.em.persist(new Familia(usuario.getPessoa()));
	}
	this.em.flush();
	return usuario;
    }





    @Transactional
    public void update(final Usuario usuario) {
	this.em.merge(usuario);
	this.em.flush();
    }





    public Usuario findUsuarioById(final Long id) {
	return this.em.find(Usuario.class, id);
    }

}