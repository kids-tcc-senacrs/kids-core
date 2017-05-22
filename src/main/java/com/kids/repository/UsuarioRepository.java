package com.kids.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kids.model.Pessoa;
import com.kids.model.Usuario;
import com.kids.moduloautorizacao.UsuarioVO;

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

	public Usuario findByEmail(@Param(value = "email") final String email) {
		try {
			final String hql = "select u from Usuario u inner join fetch u.pessoa as pessoa where u.email = :email";
			final Query query = this.em.createQuery(hql, Usuario.class);
			query.setParameter("email", StringUtils.trim(email));
			return (Usuario) query.getSingleResult();
		} catch (final Exception e) {
			return null;
		}
	}

	@Transactional
	public void save(final UsuarioVO vo) {
		final Pessoa pessoa = new Pessoa();
		pessoa.setNome(vo.getNome());
		pessoa.setFoto(vo.getFotoUrl());

		final Usuario usuario = new Usuario();
		usuario.setApelido(vo.getApelido());
		usuario.setEmail(vo.getApelido());
		usuario.setTelefone(vo.getApelido());
		usuario.setAtivo(Boolean.FALSE);
		usuario.setTipo(vo.getTipo());
		usuario.setPessoa(pessoa);

		this.em.persist(usuario);
	}

}