package com.kids.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 05/2017
 * 
 */
@Entity
@Table(name = "USUARIO", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario implements Serializable {

	private static final long serialVersionUID = -2561353904338124908L;

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_id_seq")
	@SequenceGenerator(name = "usuario_id_seq", sequenceName = "usuario_id_seq", allocationSize = 1)
	private Long id;

	@Column(name = "nome", nullable = false, length = 60)
	private String nome;

	@Column(name = "foto", nullable = true, length = 300)
	private String foto;

	@Column(name = "email", nullable = false, unique = true, length = 255)
	private String email;

	@Column(name = "telefone", nullable = true, length = 20)
	private String telefone;

	@Column(name = "apelido", nullable = true, length = 30)
	private String apelido;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", nullable = false, length = 8)
	private Tipo tipo;

	@Column(name = "ativo", nullable = false)
	private Boolean ativo;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public enum Tipo {
		CRECHE, FAMILIAR
	}

	public Long getId() {
		return id;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
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

}