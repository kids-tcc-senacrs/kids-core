package com.kids.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.github.fluent.hibernate.transformer.FluentHibernateResultTransformer;
import com.kids.enumeration.DiarioTipo;
import com.kids.model.Diario;
import com.kids.modulodiarioescolar.vo.DiarioVO;

@Repository
public class DiarioRepository {

    @PersistenceContext
    private EntityManager em;





    @SuppressWarnings("unchecked")
    public List<DiarioVO> findDiarios(final Integer crecheId, final DiarioTipo tipo) {

	final StringBuilder nativeQuery = new StringBuilder();
	nativeQuery.append(" select  diario.id    as \"diarioId\",");
	nativeQuery.append("         crianca.id   as \"criancaId\",");
	nativeQuery.append("         pessoa.nome  as \"criancaNome\",");
	nativeQuery.append("         crianca.sexo as \"criancaSexo\",");
	nativeQuery.append("         diario.tipo  as \"tipo\",");
	nativeQuery.append("         diario.nota  as \"nota\",");
	nativeQuery.append("         diario.dt_lancamento as dtLancamento");
	nativeQuery.append("   FROM PESSOA pessoa");
	nativeQuery.append("  INNER JOIN CRIANCA crianca ON pessoa.id = crianca.pessoa_id");
	nativeQuery.append("  INNER JOIN CRECHE creche   ON crianca.creche_id = creche.id");
	nativeQuery.append("   LEFT JOIN DIARIO diario   ON crianca.id = diario.id_crianca AND diario.tipo = :diarioTipo");
	nativeQuery.append("  WHERE creche.id            = :crecheId");
	//nativeQuery.append("    AND diario.dt_lancamento = current_date");
	nativeQuery.append("  ORDER BY pessoa.nome");

	final Session session = (Session) this.em.getDelegate();
	final SQLQuery query = session.createSQLQuery(nativeQuery.toString());
	query.setParameter("crecheId", crecheId.intValue());
	query.setParameter("diarioTipo", tipo.name());
	query.setResultTransformer(new FluentHibernateResultTransformer(DiarioVO.class));

	return query.list();
    }





    @Transactional
    public void persistOrUpdate(final Set<Diario> diarios) {
	if (CollectionUtils.isNotEmpty(diarios)) {
	    for (final Diario d : diarios) {
		if (d.getId() == null) {
		    this.em.persist(d);
		} else {
		    this.em.merge(d);
		}
		this.em.flush();
	    }
	}
    }





    public Diario getDiarioById(final Long id) {
	return this.em.find(Diario.class, id);
    }





    public Diario findDiario(final Long crecheId, final Long criancaId, final DiarioTipo tipo) {
	final Session session = (Session) this.em.getDelegate();
	final DetachedCriteria criteria = DetachedCriteria.forClass(Diario.class);
	criteria.add(Restrictions.eq("creche.id", crecheId));
	criteria.add(Restrictions.eq("crianca.id", criancaId));
	criteria.add(Restrictions.eq("tipo", tipo));
	criteria.add(Restrictions.eq("dtLancamento", LocalDate.now()));
	return (Diario) criteria.getExecutableCriteria(session).uniqueResult();
    }





    @SuppressWarnings("unchecked")
    public List<DiarioVO> findDiariosByFamiliar(final Integer usuarioId, final DiarioTipo tipoDiario) {
	final StringBuilder nativeQuery = new StringBuilder();
	nativeQuery.append(" select  diario.id    as \"diarioId\",");
	nativeQuery.append("         crianca.id   as \"criancaId\",");
	nativeQuery.append("         pessoa.nome  as \"criancaNome\",");
	nativeQuery.append("         crianca.sexo as \"criancaSexo\",");
	nativeQuery.append("         diario.tipo  as \"tipo\",");
	nativeQuery.append("         diario.nota  as \"nota\",");
	nativeQuery.append("         diario.dt_lancamento as dtLancamento");
	nativeQuery.append("   FROM PESSOA pessoa");
	nativeQuery.append("  INNER JOIN CRIANCA crianca ON pessoa.id = crianca.pessoa_id");
	nativeQuery.append("  INNER JOIN CRECHE creche   ON crianca.creche_id = creche.id");
	nativeQuery.append("  INNER JOIN CRIANCA_FAMILIA familia ON familia.id_crianca = crianca.id");
	nativeQuery.append("   LEFT JOIN DIARIO diario   ON crianca.id = diario.id_crianca");
	nativeQuery.append("  WHERE (diario.tipo = :diarioTipo OR diario.id is null)");
	nativeQuery.append("    AND familia.id_usuario = :usuarioId");

	final Session session = (Session) this.em.getDelegate();
	final SQLQuery query = session.createSQLQuery(nativeQuery.toString());
	query.setParameter("usuarioId", usuarioId.intValue());
	query.setParameter("diarioTipo", tipoDiario.name());
	query.setResultTransformer(new FluentHibernateResultTransformer(DiarioVO.class));

	return query.list();
    }

}