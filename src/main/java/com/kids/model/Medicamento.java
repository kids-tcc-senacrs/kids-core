package com.kids.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 * 
 */
@Entity
@Table(name = "MEDICAMENTO")
public class Medicamento implements Serializable {

	private static final long serialVersionUID = -1376527019024736261L;

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medicamento_id_seq")
	@SequenceGenerator(name = "medicamento_id_seq", sequenceName = "medicamento_id_seq", allocationSize = 1)
	private Long id;

	@Column(name = "nome", length = 40)
	private String nome;

	@Column(name = "dosagem", length = 25)
	private String dosagem;

	@Column(name = "intervalo_horas", length = 10)
	private String intervaloHoras;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_final")
	private Date dtFinal;



	public Medicamento() {
		super();
	}



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



	public String getDosagem() {
		return dosagem;
	}



	public void setDosagem(final String dosagem) {
		this.dosagem = dosagem;
	}



	public String getIntervaloHoras() {
		return intervaloHoras;
	}



	public void setIntervaloHoras(final String intervaloHoras) {
		this.intervaloHoras = intervaloHoras;
	}



	public Date getDtFinal() {
		return dtFinal;
	}



	public void setDtFinal(final Date dtFinal) {
		this.dtFinal = dtFinal;
	}
}