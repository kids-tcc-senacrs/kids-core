package com.kids.tcc.prepara.bancodedados;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class PreparaBaseDadoRepository implements Serializable {

	private static final long serialVersionUID = 2280834734709809455L;
	final static Logger LOGGER = Logger.getLogger(PreparaBaseDadoRepository.class);

	@PersistenceContext
	private EntityManager em;

	public void updateDB() {
		try {
			final LeituraArquivoSql lerArquivoSql = new LeituraArquivoSql();
			for (final String sql : lerArquivoSql.getSqls()) {
				final Session session = (Session) this.em.getDelegate();
				session.createSQLQuery(sql).executeUpdate();
			}
			LOGGER.info("KIDS - todos os scripts de testes foram executados com sucesso!!!");
		} catch (final Exception e) {
			LOGGER.error("KIDS - Ocorreu um erro ao executar scripts para preparar a base de dados para testes - TCC", e);
		}
	}
}