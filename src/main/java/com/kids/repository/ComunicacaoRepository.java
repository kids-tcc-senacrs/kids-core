package com.kids.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.github.fluent.hibernate.transformer.FluentHibernateResultTransformer;
import com.kids.model.Comunicacao;
import com.kids.modulocomunicacao.vo.ComunicacaoVO;

@Repository
public class ComunicacaoRepository {

    @PersistenceContext
    private EntityManager em;





    @SuppressWarnings("unchecked")
    public List<ComunicacaoVO> findComunicacoesByCreche(final Long crecheId) {

	final StringBuilder nativeQuery = new StringBuilder();
	nativeQuery.append(" SELECT C.id                 as \"comunicacaoId\",");
	nativeQuery.append("        P.nome               as \"usuarioNome\",");
	nativeQuery.append("        C.descricao_familiar as \"descricaoFamiliar\",");
	nativeQuery.append("        C.descricao_creche   as \"descricaoCreche\",");
	nativeQuery.append("        C.tipo               as \"tipo\",");
	nativeQuery.append("        C.creche_respondeu   as \"crecheRespondeu\",");
	nativeQuery.append("        C.dt_envio_familiar  as \"dtEnvioFamiliar\",");
	nativeQuery.append("        C.dt_resposta_creche as \"dtRespostaCreche\"");
	nativeQuery.append("  FROM COMUNICACAO C");
	nativeQuery.append("  INNER JOIN USUARIO U ON C.id_usuario = U.id");
	nativeQuery.append("  INNER JOIN PESSOA  P ON U.id_pessoa  = P.id");
	nativeQuery.append("  WHERE C.id_creche = :crecheId");

	final Session session = (Session) this.em.getDelegate();
	final SQLQuery query = session.createSQLQuery(nativeQuery.toString());
	query.setParameter("crecheId", crecheId);
	query.setResultTransformer(new FluentHibernateResultTransformer(ComunicacaoVO.class));
	return query.list();

    }





    @Transactional
    public void persist(final Comunicacao comunicacao) {
	this.em.persist(comunicacao);
	this.em.flush();
    }

}