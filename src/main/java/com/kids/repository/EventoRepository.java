package com.kids.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.github.fluent.hibernate.transformer.FluentHibernateResultTransformer;
import com.kids.enumeration.EventoStatus;
import com.kids.model.Evento;
import com.kids.moduloeventos.vo.EventoVO;

@Repository
public class EventoRepository {

    @PersistenceContext
    private EntityManager em;





    /**
     * Busca todos os eventos das creches onde o usuário familiar logado possui
     * crianças vinculadas. Limitando-se apenas a eventos que ainda não possuem
     * confirmação de presença por qualquer um dos familiares.
     * 
     * @param usuarioId
     * @return EvevtosVO
     */
    @SuppressWarnings("unchecked")
    public List<EventoVO> findEventos(final Long usuarioId) {
	final StringBuilder nativeQuery = new StringBuilder();
	nativeQuery.append("  SELECT evento.id as \"eventoId\",");
	nativeQuery.append("         crianca.id as \"criancaId\",");
	nativeQuery.append("         evento.nome as \"eventoNome\",");
	nativeQuery.append("         pessoaCrianca.nome as \"criancaNome\",");
	nativeQuery.append("         evento.descricao as \"descricao\",");
	nativeQuery.append("         evento.dt_realizacao as \"dtRealizacao\"");
	nativeQuery.append("    FROM CRIANCA crianca");
	nativeQuery.append("   INNER JOIN PESSOA pessoaCrianca     ON crianca.pessoa_id = pessoaCrianca.id");
	nativeQuery.append("   INNER JOIN CRECHE   creche          ON creche.id = crianca.creche_id");
	nativeQuery.append("   INNER JOIN CRIANCA_FAMILIA familia  ON familia.id_crianca = crianca.id AND familia.id_usuario = :usuarioId");
	nativeQuery.append("   INNER JOIN EVENTO evento            ON evento.id_creche = creche.id");
	nativeQuery.append("    LEFT JOIN EVENTO_RESPOSTA resposta ON resposta.id_evento = evento.id AND resposta.id_crianca = crianca.id");
	nativeQuery.append("  WHERE evento.dt_realizacao >= :dtRealizacao");
	nativeQuery.append("  AND evento.status != :eventoStatus");
	nativeQuery.append("  AND resposta.status is null");
	nativeQuery.append("  ORDER BY evento.dt_realizacao");

	final Session session = (Session) this.em.getDelegate();
	final SQLQuery query = session.createSQLQuery(nativeQuery.toString());
	query.setParameter("usuarioId", usuarioId.intValue());
	query.setParameter("eventoStatus", EventoStatus.CANCELADO.name());
	query.setParameter("dtRealizacao", new Date());
	query.setResultTransformer(new FluentHibernateResultTransformer(EventoVO.class));

	return query.list();
    }





    @Transactional
    public void save(final Evento evento) {
	this.em.persist(evento);
    }

}