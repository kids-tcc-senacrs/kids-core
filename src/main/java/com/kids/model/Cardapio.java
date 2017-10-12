package com.kids.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name = "CARDAPIO")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Cardapio implements Serializable {

    private static final long serialVersionUID = -4478049260039264823L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cardapio")
    @SequenceGenerator(name = "seq_cardapio", sequenceName = "seq_cardapio", allocationSize = 100, initialValue = 100)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_creche", nullable = false)
    private Creche creche;

    @Column(name = "dia_semana", nullable = false, length = 30)
    private String diaSemana;

    @Column(name = "dt_cardapio", nullable = false)
    private LocalDate dtcardapio;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cardapio")
    private List<CardapioAlimento> alimentos;





    public Long getId() {
	return id;
    }





    public void setId(Long id) {
	this.id = id;
    }





    public Creche getCreche() {
	return creche;
    }





    public void setCreche(Creche creche) {
	this.creche = creche;
    }





    public String getDiaSemana() {
	return diaSemana;
    }





    public void setDiaSemana(String diaSemana) {
	this.diaSemana = diaSemana;
    }





    public LocalDate getDtcardapio() {
	return dtcardapio;
    }





    public void setDtcardapio(LocalDate dtcardapio) {
	this.dtcardapio = dtcardapio;
    }





    public List<CardapioAlimento> getAlimentos() {
	return alimentos;
    }





    public void setAlimentos(List<CardapioAlimento> alimentos) {
	this.alimentos = alimentos;
    }

}