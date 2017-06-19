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

	@Column(name = "cep", length = 8)
	private String cep;

	@Column(name = "logradouro", length = 200)
	private String logradouro;

	@Column(name = "complemento", length = 200)
	private String complemento;



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



	public String getComplemento() {
		return complemento;
	}



	public void setComplemento(final String complemento) {
		this.complemento = complemento;
	}
}