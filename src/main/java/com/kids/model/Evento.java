package com.kids.model;

import java.io.Serializable;
import java.time.LocalDateTime;

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
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.kids.enumeration.EventoStatus;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 09/2017
 * 
 */
@Entity
@Table(name = "EVENTO")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Evento implements Serializable {

    private static final long serialVersionUID = 8433449795250662499L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "sequenceEvento", strategy = GenerationType.TABLE)
    @TableGenerator(name = "sequenceEvento", allocationSize = 1)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_creche")
    private Creche creche;

    @Column(name = "nome", length = 60)
    private String nome;

    @Column(name = "descricao", length = 255)
    private String descricao;

    @Column(name = "dt_realizacao")
    private LocalDateTime dtRealizacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 10)
    private EventoStatus status;





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





    public String getNome() {
	return nome;
    }





    public void setNome(String nome) {
	this.nome = nome;
    }





    public String getDescricao() {
	return descricao;
    }





    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }





    public LocalDateTime getDtRealizacao() {
	return dtRealizacao;
    }





    public void setDtRealizacao(LocalDateTime dtRealizacao) {
	this.dtRealizacao = dtRealizacao;
    }





    public EventoStatus getStatus() {
	return status;
    }





    public void setStatus(EventoStatus status) {
	this.status = status;
    }





    @Override
    public String toString() {
	return new ToStringBuilder(this)//
	        .append("id", this.id)//
	        .append("creche", this.creche)//
	        .append("nome", this.nome)//
	        .append("descricao", this.descricao)//
	        .append("dtRealizacao", this.dtRealizacao)//
	        .append("status", this.status)//
	        .toString();//
    }

}