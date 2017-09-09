package com.kids.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.github.fluent.hibernate.transformer.FluentHibernateResultTransformer;
import com.kids.model.Aviso;
import com.kids.moduloaviso.vo.AvisoVO;

@Repository
public class AvisoRepository {

    @PersistenceContext
    private EntityManager em;





    @Transactional
    public void persist(Aviso aviso) {
	this.em.persist(aviso);
    }





    @SuppressWarnings("unchecked")
    public List<AvisoVO> findAllNaoExpirados(final Long usuarioId) {
	final StringBuilder nativeQuery = new StringBuilder();
	nativeQuery.append("  SELECT distinct(aviso.id) as \"avisoId\",");
	nativeQuery.append("         pessoaCreche.nome as \"crecheNome\",");
	nativeQuery.append("         aviso.descricao as \"descricao\",");
	nativeQuery.append("         aviso.tipo as \"tipo\",");
	nativeQuery.append("         aviso.dt_expiracao as \"dtExpiracao\"");
	nativeQuery.append("    FROM AVISO aviso");
	nativeQuery.append("   INNER JOIN CRECHE creche          ON aviso.id_creche          = creche.id");
	nativeQuery.append("   INNER JOIN PESSOA pessoaCreche    ON pessoaCreche.id          = creche.id_pessoa");
	nativeQuery.append("   INNER JOIN USUARIO usuarioCreche  ON usuarioCreche.id_pessoa  = pessoaCreche.id");
	nativeQuery.append("   INNER JOIN CRIANCA crianca        ON crianca.creche_id        = creche.id	");
	nativeQuery.append("   INNER JOIN CRIANCA_FAMILIA cf     ON cf.id_crianca            = crianca.id");
	nativeQuery.append("   INNER JOIN FAMILIA f              ON f.id                     = cf.id_familia");
	nativeQuery.append("   INNER JOIN PESSOA pessoaFamilia   ON pessoaFamilia.id         = f.id_pessoa");
	nativeQuery.append("   INNER JOIN USUARIO usuarioFamilia ON usuarioFamilia.id_pessoa = pessoaFamilia.id");
	nativeQuery.append("   WHERE usuarioFamilia.id = :usuarioId");
	nativeQuery.append("  AND aviso.dt_expiracao >= now()");

	final Session session = (Session) this.em.getDelegate();
	final SQLQuery query = session.createSQLQuery(nativeQuery.toString());
	query.setParameter("usuarioId", usuarioId);
	query.setResultTransformer(new FluentHibernateResultTransformer(AvisoVO.class));
	return query.list();
    }

}