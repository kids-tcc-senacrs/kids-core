package com.kids.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.FetchMode;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.github.fluent.hibernate.transformer.FluentHibernateResultTransformer;
import com.kids.model.Creche;
import com.kids.model.Usuario;
import com.kids.modulocrianca.vo.CrecheVO;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 * 
 */
@Repository
public class CrecheRepository {

    @PersistenceContext
    private EntityManager em;





    public Creche find(final Long id) {
	final Session session = (Session) this.em.getDelegate();
	final DetachedCriteria criteria = DetachedCriteria.forClass(Creche.class, "creche");
	criteria.createAlias("creche.pessoa", "pessoa", JoinType.INNER_JOIN);
	criteria.setFetchMode("creche.pessoa", FetchMode.SELECT);
	criteria.add(Restrictions.eq("creche.id", id));
	return (Creche) criteria.getExecutableCriteria(session).uniqueResult();
    }





    public Creche findCrecheByUsuario(final Usuario usuario) {
	final Session session = (Session) this.em.getDelegate();
	final DetachedCriteria criteria = DetachedCriteria.forClass(Creche.class, "creche");
	criteria.createAlias("creche.pessoa", "pessoa", JoinType.INNER_JOIN);
	criteria.setFetchMode("creche.pessoa", FetchMode.SELECT);
	criteria.add(Restrictions.eq("creche.pessoa", usuario.getPessoa()));
	return (Creche) criteria.getExecutableCriteria(session).uniqueResult();
    }





    @SuppressWarnings("unchecked")
    public List<CrecheVO> findCrecheByFamiliarVinculado(final Long usuarioId) {
	final StringBuilder nativeQuery = new StringBuilder();
	nativeQuery.append(" SELECT distinct(creche.id) as \"id\",");
	nativeQuery.append("        pessoaCreche.nome as \"nome\"");
	nativeQuery.append("   FROM CRIANCA_FAMILIA CF");
	nativeQuery.append("  INNER JOIN CRIANCA crianca ON CF.id_crianca = crianca.id");
	nativeQuery.append("  INNER JOIN CRECHE creche  ON crianca.creche_id = creche.id");
	nativeQuery.append("  INNER JOIN PESSOA pessoaCreche ON creche.id_pessoa = pessoaCreche.id");
	nativeQuery.append("  WHERE CF.id_usuario = :usuarioId");
	final Session session = (Session) this.em.getDelegate();
	final SQLQuery query = session.createSQLQuery(nativeQuery.toString());
	query.setParameter("usuarioId", usuarioId);
	query.setResultTransformer(new FluentHibernateResultTransformer(CrecheVO.class));
	return query.list();
    }

}