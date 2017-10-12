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
import com.kids.model.Cardapio;
import com.kids.modulocardapio.vo.CardapioVO;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 10/2017
 * 
 */
@Repository
public class CardapioRepository {

    @PersistenceContext
    private EntityManager em;





    @Transactional
    public void persist(Avaliacao avaliacao) {
	this.em.persist(avaliacao);
    }





    @SuppressWarnings("unchecked")
    public List<CardapioVO> findCardapiosByCreche(final Long crecheId) {
	final StringBuilder nativeQuery = new StringBuilder();
	nativeQuery.append("  SELECT C.id          as \"cardapioId\",");
	nativeQuery.append("         P.nome        as \"crecheNome\",");
	nativeQuery.append("         C.dia_semana  as \"diaSemana\",");
	nativeQuery.append("         C.dt_cardapio as \"dtCardapio\"");
	nativeQuery.append("    FROM CARDAPIO C");
	nativeQuery.append("   INNER JOIN CRECHE CR ON C.id_creche = CR.id");
	nativeQuery.append("   INNER JOIN PESSOA  P ON CR.id_pessoa = P.id");
	nativeQuery.append("   WHERE CR.id = :crecheId ");
	final Session session = (Session) this.em.getDelegate();
	final SQLQuery query = session.createSQLQuery(nativeQuery.toString());
	query.setParameter("crecheId", crecheId);
	query.setResultTransformer(new FluentHibernateResultTransformer(CardapioVO.class));
	return query.list();
    }





    @Transactional
    public void save(final Cardapio cardapio) {
	this.em.persist(cardapio);
    }

}