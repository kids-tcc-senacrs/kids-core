package com.kids.tcc.prepara.bancodedados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class LeituraArquivoSql {

	final static String PATH_FILE_SQL = "src/main/java/com/kids/tcc/prepara/bancodedados/base-testes.csv";
	final static Logger LOGGER = Logger.getLogger(LeituraArquivoSql.class);
	private List<String> sqls = new ArrayList<String>();

	public LeituraArquivoSql() {
		BufferedReader br = null;
		String sql = "";
		try {
			LOGGER.info("KIDS - INICIO DA LEITURA DOS SCRIPTS SQL");
			br = new BufferedReader(new FileReader(PATH_FILE_SQL));
			while ((sql = br.readLine()) != null) {
				sqls.add(sql);
			}
			LOGGER.info("KIDS - FIM DA LEITURA DOS SCRIPTS SQL");
		} catch (final Exception e) {
			LOGGER.error("KIDS - OCORREU UM ERRO AO LER OS SCRIPTS SQL", e);
		}
	}

	public List<String> getSqls() {
		return sqls;
	}

}