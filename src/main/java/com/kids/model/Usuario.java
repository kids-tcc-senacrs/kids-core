package com.kids.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 05/2017
 * 
 */
@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {

	private static final long serialVersionUID = -2561353904338124908L;

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_id_seq")
	@SequenceGenerator(name = "usuario_id_seq", sequenceName = "usuario_id_seq", allocationSize = 1)
	private Long id;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "telefone", nullable = true)
	private String telefone;

	@Column(name = "apelido", nullable = true)
	private String apelido;

	@Column(name = "tipo", nullable = false)
	private Tipo tipo;

	@Column(name = "ativo", nullable = false)
	private Boolean ativo;

	private enum Tipo {
		/**
		 * representa uma instituição de ensino
		 */
		CRECHE, //
		/**
		 * representa uma pessoa responsável por alguma criança
		 */
		RESPONSAVEL
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(final String telefone) {
		this.telefone = telefone;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(final String apelido) {
		this.apelido = apelido;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(final Tipo tipo) {
		this.tipo = tipo;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(final Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("email", email).append("telefone", telefone)
				.append("apelido", apelido).append("tipo", tipo).append("ativo", ativo).toString();
	}

}