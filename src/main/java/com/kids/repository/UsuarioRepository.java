package com.kids.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
		try {
			final String hql = "select u from Usuario u left join fetch u.endereco as endereco where u.email = :email";
			final Query query = this.em.createQuery(hql, Usuario.class);
			query.setParameter("email", StringUtils.trim(email));
			return (Usuario) query.getSingleResult();
		} catch (final Exception e) {
			return null;
		}
	}



	@Transactional
	public Usuario save(final Usuario usuario) {
		this.em.persist(usuario);
		this.em.flush();
		return usuario;
	}



	@Transactional
	public Usuario update(final Usuario usuario) {
		this.em.merge(usuario);
		this.em.flush();
		return usuario;
	}



	public Usuario findUsuarioById(final Long id) {
		return this.em.find(Usuario.class, id);
	}
}