package com.kids.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.apache.commons.lang3.builder.ToStringBuilder;

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
	@GeneratedValue(generator = "sequenceMedicamento", strategy = GenerationType.TABLE)
	@TableGenerator(name = "sequenceMedicamento", allocationSize = 1)
	private Long id;

	@Column(name = "nome", length = 40)
	private String nome;

	@Column(name = "dosagem", length = 25)
	private String dosagem;

	@Column(name = "intervalo_horas", length = 10)
	private String intervaloHoras;

	@Column(name = "dt_final")
	private LocalDate dtFinal;

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

	public LocalDate getDtFinal() {
		return dtFinal;
	}

	public void setDtFinal(final LocalDate dtFinal) {
		this.dtFinal = dtFinal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medicamento other = (Medicamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)//
				.append("id", this.id)//
				.append("nome", this.nome)//
				.append("dosagem", this.dosagem)//
				.append("intervaloHoras", this.intervaloHoras)//
				.append("dtFinal", this.dtFinal)//
				.toString();//
	}

}