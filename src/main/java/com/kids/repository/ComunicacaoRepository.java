package com.kids.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.kids.modulocomunicacao.vo.ComunicacaoVO;

@Repository
public class ComunicacaoRepository {

    @PersistenceContext
    private EntityManager em;





    //TODO:https://github.com/kids-tcc-senacrs/kids-core/issues/14
    public List<ComunicacaoVO> findComunicacoesByCreche(final Long crecheId) {
	/*
	 * final StringBuilder nativeQuery = new StringBuilder();
	 * nativeQuery.append(" select  diario.id    as \"diarioId\",");
	 * nativeQuery.append("         crianca.id   as \"criancaId\",");
	 * nativeQuery.append("         pessoa.nome  as \"criancaNome\",");
	 * nativeQuery.append("         crianca.sexo as \"criancaSexo\",");
	 * nativeQuery.append("         diario.tipo  as \"tipo\",");
	 * nativeQuery.append("         diario.nota  as \"nota\",");
	 * nativeQuery.append("         diario.dt_lancamento as dtLancamento");
	 * nativeQuery.append("   FROM PESSOA pessoa"); nativeQuery.
	 * append("  INNER JOIN CRIANCA crianca ON pessoa.id = crianca.pessoa_id"
	 * ); nativeQuery.
	 * append("  INNER JOIN CRECHE creche   ON crianca.creche_id = creche.id"
	 * ); nativeQuery.
	 * append("  INNER JOIN CRIANCA_FAMILIA familia ON familia.id_crianca = crianca.id"
	 * ); nativeQuery.
	 * append("   LEFT JOIN DIARIO diario   ON crianca.id = diario.id_crianca AND diario.tipo = :diarioTipo"
	 * ); nativeQuery.append("  WHERE familia.id_usuario = :usuarioId");
	 * 
	 * final Session session = (Session) this.em.getDelegate(); final
	 * SQLQuery query = session.createSQLQuery(nativeQuery.toString());
	 * //query.setParameter("usuarioId", usuarioId.intValue());
	 * //query.setParameter("diarioTipo", tipoDiario.name());
	 * query.setResultTransformer(new
	 * FluentHibernateResultTransformer(ComunicacaoVO.class));
	 * 
	 * return query.list();
	 */
	return new ArrayList<>();
    }

}