package com.kids.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.github.fluent.hibernate.transformer.FluentHibernateResultTransformer;
import com.kids.model.Galeria;
import com.kids.modulogaleria.vo.GaleriaVO;

@Repository
public class GaleriaRepository {

    @PersistenceContext
    private EntityManager em;





    @Transactional
    public Galeria persist(final Galeria galeria) {
	this.em.persist(galeria);
	this.em.flush();
	return galeria;
    }





    @SuppressWarnings("unchecked")
    public List<GaleriaVO> findGaleriasByCrecheId(final Long crecheId) {
	final StringBuilder nativeQuery = new StringBuilder();
	nativeQuery.append("  SELECT G.id         as \"id\",");
	nativeQuery.append("         G.descricao  as \"descricao\",");
	nativeQuery.append("         G.dt_post    as \"dtPost\",");
	nativeQuery.append("         G.imagem     as \"imagem\"");
	nativeQuery.append("    FROM GALERIA G");
	nativeQuery.append("   WHERE G.creche_id = :crecheId ");
	nativeQuery.append("    ORDER BY  G.dt_post DESC");

	final Session session = (Session) this.em.getDelegate();
	final SQLQuery query = session.createSQLQuery(nativeQuery.toString());
	query.setParameter("crecheId", crecheId);
	query.setResultTransformer(new FluentHibernateResultTransformer(GaleriaVO.class));
	return query.list();
    }





    @Transactional
    public void update(final Galeria galeria) {
	this.em.merge(galeria);
	this.em.flush();
    }

}