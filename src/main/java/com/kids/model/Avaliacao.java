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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 10/2017
 * 
 */
@Entity
@Table(name = "AVALIACAO")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Avaliacao implements Serializable {

    private static final long serialVersionUID = 8433449795250662499L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_avaliacao")
    @SequenceGenerator(name = "seq_avaliacao", sequenceName = "seq_avaliacao", allocationSize = 100, initialValue = 100)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_creche", nullable = false)
    private Creche creche;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_crianca", nullable = false)
    private Crianca crianca;

    @Column(name = "descricao", nullable = false, length = 1000)
    private String descricao;

    @Column(name = "dt_avaliacao", nullable = false)
    private LocalDate dtAvaliacao;





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





    public String getDescricao() {
	return descricao;
    }





    public void setDescricao(final String descricao) {
	this.descricao = descricao;
    }





    public LocalDate getDtAvaliacao() {
	return dtAvaliacao;
    }





    public void setDtAvaliacao(final LocalDate dtAvaliacao) {
	this.dtAvaliacao = dtAvaliacao;
    }

}