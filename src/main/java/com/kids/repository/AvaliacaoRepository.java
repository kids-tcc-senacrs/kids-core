package com.kids.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.github.fluent.hibernate.transformer.FluentHibernateResultTransformer;
import com.kids.model.Avaliacao;
import com.kids.moduloavaliacao.vo.AvaliacaoVO;

@Repository
public class AvaliacaoRepository {

    @PersistenceContext
    private EntityManager em;





    @Transactional
    public void persist(Avaliacao avaliacao) {
	this.em.persist(avaliacao);
    }





    @SuppressWarnings("unchecked")
    public List<AvaliacaoVO> findAvaliacoes(final Long criancaId) {
	final StringBuilder nativeQuery = new StringBuilder();
	nativeQuery.append("  SELECT A.id           as \"avaliacaoId\",");
	nativeQuery.append("         Pcreche.nome   as \"crecheNome\",");
	nativeQuery.append("         Pcrianca.nome  as \"criancaNome\",");
	nativeQuery.append("         A.descricao    as \"descricao\",");
	nativeQuery.append("         A.dt_avaliacao as \"dtAvaliacao\"");
	nativeQuery.append("    FROM AVALIACAO A");
	nativeQuery.append("   INNER JOIN CRECHE   C       ON A.id_creche  = C.id");
	nativeQuery.append("   INNER JOIN CRIANCA CR       ON A.id_crianca = CR.id");
	nativeQuery.append("   INNER JOIN PESSOA Pcreche   ON C.id_pessoa  = Pcreche.id");
	nativeQuery.append("   INNER JOIN PESSOA Pcrianca  ON CR.pessoa_id = Pcrianca.id");
	nativeQuery.append("   WHERE id_crianca = :criancaId");
	final Session session = (Session) this.em.getDelegate();
	final SQLQuery query = session.createSQLQuery(nativeQuery.toString());
	query.setParameter("criancaId", criancaId);
	query.setResultTransformer(new FluentHibernateResultTransformer(AvaliacaoVO.class));
	return query.list();
    }





    @Transactional
    public void save(final Avaliacao avaliacao) {
	this.em.persist(avaliacao);
    }

}