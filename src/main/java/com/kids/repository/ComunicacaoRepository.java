package com.kids.repository;

import java.util.Collection;
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





    public Comunicacao findComunicacaoById(final Long id) {
	return this.em.find(Comunicacao.class, id);
    }





    @Transactional
    public void update(final Comunicacao comunicacao) {
	this.em.merge(comunicacao);
    }





    @SuppressWarnings("unchecked")
    public List<ComunicacaoVO> findComunicacoesByUsuarioFamiliar(final Long usuarioId) {
	final StringBuilder nativeQuery = new StringBuilder();
	nativeQuery.append(" SELECT C.id                 as \"comunicacaoId\",");
	nativeQuery.append("        P.nome               as \"usuarioNome\",");
	nativeQuery.append("        C.descricao_familiar as \"descricaoFamiliar\",");
	nativeQuery.append("        C.descricao_creche   as \"descricaoCreche\",");
	nativeQuery.append("        C.tipo               as \"tipo\",");
	nativeQuery.append("        C.creche_respondeu   as \"crecheRespondeu\",");
	nativeQuery.append("        C.dt_envio_familiar  as \"dtEnvioFamiliar\",");
	nativeQuery.append("        C.dt_resposta_creche as \"dtRespostaCreche\",");
	nativeQuery.append("        Pcreche.nome as \"crecheNome\"");
	nativeQuery.append("  FROM COMUNICACAO C");
	nativeQuery.append("  INNER JOIN USUARIO U     ON C.id_usuario = U.id");
	nativeQuery.append("  INNER JOIN PESSOA  P     ON U.id_pessoa  = P.id");
	nativeQuery.append("  INNER JOIN CRECHE creche ON creche.id = C.id_creche");
	nativeQuery.append("  INNER JOIN PESSOA  Pcreche ON Pcreche.id  = creche.id_pessoa");
	nativeQuery.append("  WHERE C.id_usuario = :usuarioId");
	nativeQuery.append("  ORDER BY C.dt_envio_familiar DESC");

	final Session session = (Session) this.em.getDelegate();
	final SQLQuery query = session.createSQLQuery(nativeQuery.toString());
	query.setParameter("usuarioId", usuarioId);
	query.setResultTransformer(new FluentHibernateResultTransformer(ComunicacaoVO.class));
	return query.list();
    }





    @SuppressWarnings("unchecked")
    public Collection<? extends ComunicacaoVO> findComunicacoesByUsuarioCreche(final Long crecheId) {
	final StringBuilder nativeQuery = new StringBuilder();
	nativeQuery.append(" SELECT C.id                 as \"comunicacaoId\",");
	nativeQuery.append("        C.id_usuario         as \"usuarioId\",");
	nativeQuery.append("        P.nome               as \"usuarioNome\",");
	nativeQuery.append("        C.descricao_familiar as \"descricaoFamiliar\",");
	nativeQuery.append("        C.descricao_creche   as \"descricaoCreche\",");
	nativeQuery.append("        C.tipo               as \"tipo\",");
	nativeQuery.append("        C.creche_respondeu   as \"crecheRespondeu\",");
	nativeQuery.append("        C.dt_envio_familiar  as \"dtEnvioFamiliar\",");
	nativeQuery.append("        C.dt_resposta_creche as \"dtRespostaCreche\",");
	nativeQuery.append("        Pcreche.nome as \"crecheNome\"");
	nativeQuery.append("  FROM COMUNICACAO C");
	nativeQuery.append("  INNER JOIN USUARIO U     ON C.id_usuario = U.id");
	nativeQuery.append("  INNER JOIN PESSOA  P     ON U.id_pessoa  = P.id");
	nativeQuery.append("  INNER JOIN CRECHE creche ON creche.id = C.id_creche");
	nativeQuery.append("  INNER JOIN PESSOA  Pcreche ON Pcreche.id  = creche.id_pessoa");
	nativeQuery.append("  WHERE creche.id = :crecheId");
	nativeQuery.append("  ORDER BY C.dt_envio_familiar DESC");

	final Session session = (Session) this.em.getDelegate();
	final SQLQuery query = session.createSQLQuery(nativeQuery.toString());
	query.setParameter("crecheId", crecheId);
	query.setResultTransformer(new FluentHibernateResultTransformer(ComunicacaoVO.class));
	return query.list();
    }

}