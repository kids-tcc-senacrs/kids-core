package com.kids.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.kids.enumeration.Sexo;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 * 
 */
@Entity
@Table(name = "CRIANCA")
public class Crianca implements Serializable {

	private static final long serialVersionUID = -5831956911955418351L;

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(generator = "sequenceCrianca", strategy = GenerationType.TABLE)
	@TableGenerator(name = "sequenceCrianca", allocationSize = 1)
	private Long id;

	@Column(name = "nome", nullable = false, length = 60)
	private String nome;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_nascimento", nullable = false)
	private Date dtNascimento;

	@Enumerated(EnumType.STRING)
	@Column(name = "sexo", nullable = false)
	private Sexo sexo;

	@Column(name = "matricula", length = 10)
	private String matricula;

	@Column(name = "foto")
	private String foto;

	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "endereco_id", foreignKey = @ForeignKey(name = "FK_endereco"))
	private Endereco endereco;

	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "contato_id", foreignKey = @ForeignKey(name = "FK_contato"))
	private Contato contato;

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "CRIANCA_MEDICAMENTO", joinColumns = @JoinColumn(name = "id_crianca", table = "CRIANCA", foreignKey = @ForeignKey(name = "FK_crianca")), inverseJoinColumns = @JoinColumn(name = "id_medicamento", table = "MEDICAMENTO", foreignKey = @ForeignKey(name = "FK_medicamento")))
	private Set<Medicamento> medicamentos;

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "CRIANCA_ALERGIA", joinColumns = @JoinColumn(name = "id_crianca", table = "CRIANCA", foreignKey = @ForeignKey(name = "FK_crianca")), inverseJoinColumns = @JoinColumn(name = "id_alergia", table = "ALERGIA", foreignKey = @ForeignKey(name = "FK_alergia")))
	private Set<Alergia> alergias;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "CRIANCA_CRECHE", joinColumns = @JoinColumn(name = "id_crianca", table = "CRIANCA", foreignKey = @ForeignKey(name = "FK_crianca")), inverseJoinColumns = @JoinColumn(name = "id_creche", table = "CRECHE", foreignKey = @ForeignKey(name = "FK_creche")))
	private Set<Creche> creches;



	public Long getId() {
		return id;
	}



	public void setId(final Long id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(final String nome) {
		this.nome = nome;
	}



	public Date getDtNascimento() {
		return dtNascimento;
	}



	public void setDtNascimento(final Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}



	public Sexo getSexo() {
		return sexo;
	}



	public void setSexo(final Sexo sexo) {
		this.sexo = sexo;
	}



	public String getMatricula() {
		return matricula;
	}



	public void setMatricula(final String matricula) {
		this.matricula = matricula;
	}



	public String getFoto() {
		return foto;
	}



	public void setFoto(String foto) {
		this.foto = foto;
	}



	public Endereco getEndereco() {
		return endereco;
	}



	public void setEndereco(final Endereco endereco) {
		this.endereco = endereco;
	}



	public Contato getContato() {
		return contato;
	}



	public void setContato(final Contato contato) {
		this.contato = contato;
	}



	public Set<Medicamento> getMedicamentos() {
		return medicamentos;
	}



	public void setMedicamentos(final Set<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}



	public Set<Alergia> getAlergias() {
		return alergias;
	}



	public void setAlergias(final Set<Alergia> alergias) {
		this.alergias = alergias;
	}



	public Set<Creche> getCreches() {
		return creches;
	}



	public void setCreches(final Set<Creche> creches) {
		this.creches = creches;
	}
}