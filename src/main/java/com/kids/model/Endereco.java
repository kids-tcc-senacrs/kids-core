package com.kids.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 05/2017
 * 
 */
@Entity
@Table(name = "ENDERECO")
public class Endereco implements Serializable {

	private static final long serialVersionUID = 7505989989856840679L;

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_id_seq")
	@SequenceGenerator(name = "endereco_id_seq", sequenceName = "endereco_id_seq", allocationSize = 1)
	private Long id;

	@Column(name = "cep", length = 8, nullable = false)
	private String cep;

	@Column(name = "logradouro", length = 60, nullable = false)
	private String logradouro;

	@Column(name = "localizacao", length = 120, nullable = false)
	private String localizacao;



	public Endereco() {
		super();
	}



	public Long getId() {
		return id;
	}



	public void setId(final Long id) {
		this.id = id;
	}



	public String getCep() {
		return cep;
	}



	public void setCep(final String cep) {
		this.cep = cep;
	}



	public String getLogradouro() {
		return logradouro;
	}



	public void setLogradouro(final String logradouro) {
		this.logradouro = logradouro;
	}



	public String getLocalizacao() {
		return localizacao;
	}



	public void setLocalizacao(final String localizacao) {
		this.localizacao = localizacao;
	}
}