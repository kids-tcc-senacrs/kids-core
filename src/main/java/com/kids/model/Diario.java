package com.kids.model;

import java.io.Serializable;
import java.time.LocalDate;

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

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.kids.enumeration.DiarioNota;
import com.kids.enumeration.DiarioTipo;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 08/2017
 * 
 */
@Entity
@Table(name = "DIARIO", uniqueConstraints = @UniqueConstraint(columnNames = { "id_creche", "id_crianca", "tipo", "dt_lancamento" }, name = "UQ_DIARIO"))
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Diario implements Serializable {

    private static final long serialVersionUID = 5613422735900946778L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_diario")
    @SequenceGenerator(name = "seq_diario", sequenceName = "seq_diario", allocationSize = 100, initialValue = 100)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_creche", nullable = false)
    private Creche creche;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_crianca", nullable = false)
    private Crianca crianca;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private DiarioTipo tipo;

    @Enumerated(EnumType.STRING)
    @Column(name = "nota", nullable = false)
    private DiarioNota nota;

    @Column(name = "dt_lancamento", nullable = false)
    private LocalDate dtLancamento;





    public Diario() {
	super();
    }





    public Long getId() {
	return id;
    }





    public void setId(final Long id) {
	this.id = id;
    }





    public Creche getCreche() {
	return creche;
    }





    public void setCreche(final Creche creche) {
	this.creche = creche;
    }





    public Crianca getCrianca() {
	return crianca;
    }





    public void setCrianca(final Crianca crianca) {
	this.crianca = crianca;
    }





    public DiarioTipo getTipo() {
	return tipo;
    }





    public void setTipo(final DiarioTipo tipo) {
	this.tipo = tipo;
    }





    public DiarioNota getNota() {
	return nota;
    }





    public void setNota(final DiarioNota nota) {
	this.nota = nota;
    }





    public LocalDate getDtLancamento() {
	return dtLancamento;
    }





    public void setDtLancamento(final LocalDate dtLancamento) {
	this.dtLancamento = dtLancamento;
    }





    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((creche == null) ? 0 : creche.hashCode());
	result = prime * result + ((crianca == null) ? 0 : crianca.hashCode());
	result = prime * result + ((dtLancamento == null) ? 0 : dtLancamento.hashCode());
	result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
	Diario other = (Diario) obj;
	if (creche == null) {
	    if (other.creche != null)
		return false;
	} else if (!creche.equals(other.creche))
	    return false;
	if (crianca == null) {
	    if (other.crianca != null)
		return false;
	} else if (!crianca.equals(other.crianca))
	    return false;
	if (dtLancamento == null) {
	    if (other.dtLancamento != null)
		return false;
	} else if (!dtLancamento.equals(other.dtLancamento))
	    return false;
	if (tipo != other.tipo)
	    return false;
	return true;
    }

}