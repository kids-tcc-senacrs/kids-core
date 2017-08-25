package com.kids.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

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
@Table(name = "DIARIO")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Diario implements Serializable {

    private static final long serialVersionUID = 5613422735900946778L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "sequenceDiario", strategy = GenerationType.TABLE)
    @TableGenerator(name = "sequenceDiario", allocationSize = 1)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_creche", nullable = false)
    private Creche creche;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_crianca", nullable = false)
    private Crianca crianca;

    @Column(name = "tipo", nullable = false)
    private DiarioTipo tipo;

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

}