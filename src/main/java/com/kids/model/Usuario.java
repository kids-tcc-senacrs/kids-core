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

import com.kids.enumeration.TipoUsuario;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 05/2017
 * 
 */
@Entity
@Table(name = "USUARIO", uniqueConstraints = @UniqueConstraint(columnNames = "email", name = "UK_usuario_email"))
public class Usuario implements Serializable {

	private static final long serialVersionUID = -2561353904338124908L;

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_id_seq")
	@SequenceGenerator(name = "usuario_id_seq", sequenceName = "usuario_id_seq", allocationSize = 1)
	private Long id;

	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "pessoa_id", nullable = false)
	private Pessoa pessoa;

	@Column(name = "email", nullable = false, unique = true, length = 255)
	private String email;

	@Column(name = "telefone", nullable = true, length = 20)
	private String telefone;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", nullable = false, length = 8)
	private TipoUsuario tipo;

	@Column(name = "ativo", nullable = false)
	private Boolean ativo;



	public Usuario() {
		super();
		this.setPessoa(new Pessoa());
	}



	public Usuario(final String email) {
		super();
		this.email = email;
	}



	public Long getId() {
		return id;
	}



	public void setId(final Long id) {
		this.id = id;
	}



	public Pessoa getPessoa() {
		return pessoa;
	}



	public void setPessoa(final Pessoa pessoa) {
		this.pessoa = pessoa;
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



	public TipoUsuario getTipo() {
		return tipo;
	}



	public void setTipo(final TipoUsuario tipo) {
		this.tipo = tipo;
	}



	public Boolean getAtivo() {
		return ativo;
	}



	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
}