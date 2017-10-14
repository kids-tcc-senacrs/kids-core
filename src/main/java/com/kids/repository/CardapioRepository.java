package com.kids.repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.github.fluent.hibernate.transformer.FluentHibernateResultTransformer;
import com.kids.model.Cardapio;
import com.kids.model.Creche;
import com.kids.modulocardapio.vo.AlimentoVO;
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
    public void persist(final Cardapio cardapio) {
	this.em.persist(cardapio);
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
	nativeQuery.append("     AND C.DT_CARDAPIO <= current_date LIMIT 7 ");

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





    public Cardapio findById(final Long id) {
	return this.em.find(Cardapio.class, id);
    }





    @Transactional
    public void remove(final Cardapio cardapio) {
	this.em.remove(cardapio);
    }





    @SuppressWarnings("unchecked")
    public List<AlimentoVO> findAlimentosByCardapioId(final Long cardapioId) {
	final StringBuilder nativeQuery = new StringBuilder();
	nativeQuery.append("  SELECT CA.id          as \"alimentoId\",");
	nativeQuery.append("         CA.nome        as \"nome\"");
	nativeQuery.append("    FROM CARDAPIO_ALIMENTO CA");
	nativeQuery.append("   WHERE CA.id_cardapio = :cardapioId ");
	final Session session = (Session) this.em.getDelegate();
	final SQLQuery query = session.createSQLQuery(nativeQuery.toString());
	query.setParameter("cardapioId", cardapioId);
	query.setResultTransformer(new FluentHibernateResultTransformer(AlimentoVO.class));
	return query.list();
    }





    public Cardapio findCardapiosByCreche(final Creche creche, final LocalDate dtCardapio) {
	final Session session = (Session) this.em.getDelegate();
	final DetachedCriteria criteria = DetachedCriteria.forClass(Cardapio.class);
	criteria.add(Restrictions.eq("creche", creche));
	criteria.add(Restrictions.eq("dtCardapio", dtCardapio));
	return (Cardapio) criteria.getExecutableCriteria(session).uniqueResult();

    }

}