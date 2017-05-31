package com.kids.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kids.enumeration.UF;

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

	@Column(name = "logradouro", length = 80)
	private String logradouro;

	@Column(name = "bairro", length = 30)
	private String bairro;

	@Column(name = "cidade", length = 60)
	private String cidade;

	@Enumerated(EnumType.STRING)
	@Column(name = "estado", length = 2)
	private UF estado;



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



	public String getBairro() {
		return bairro;
	}



	public void setBairro(final String bairro) {
		this.bairro = bairro;
	}



	public String getCidade() {
		return cidade;
	}



	public void setCidade(final String cidade) {
		this.cidade = cidade;
	}



	public UF getEstado() {
		return estado;
	}



	public void setEstado(final UF estado) {
		this.estado = estado;
	}
}