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

import com.kids.enumeration.EventoRespostaStatus;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 09/2017
 * 
 */
@Entity
@Table(name = "EVENTO_RESPOSTA")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class EventoResposta implements Serializable {

    private static final long serialVersionUID = 8433449795250662499L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "sequenceEventoResposta", strategy = GenerationType.TABLE)
    @TableGenerator(name = "sequenceEventoResposta", allocationSize = 1)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evento")
    private Evento evento;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_crianca")
    private Crianca crianca;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EventoRespostaStatus status;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario responsavel;

    @Column(name = "dt_resposta")
    private LocalDateTime dtResposta;





    public Long getId() {
	return id;
    }





    public void setId(Long id) {
	this.id = id;
    }





    public Evento getEvento() {
	return evento;
    }





    public void setEvento(Evento evento) {
	this.evento = evento;
    }





    public Crianca getCrianca() {
	return crianca;
    }





    public void setCrianca(Crianca crianca) {
	this.crianca = crianca;
    }





    public EventoRespostaStatus getStatus() {
	return status;
    }





    public void setStatus(EventoRespostaStatus status) {
	this.status = status;
    }





    public Usuario getResponsavel() {
	return responsavel;
    }





    public void setResponsavel(Usuario responsavel) {
	this.responsavel = responsavel;
    }





    public LocalDateTime getDtResposta() {
	return dtResposta;
    }





    public void setDtResposta(LocalDateTime dtResposta) {
	this.dtResposta = dtResposta;
    }





    @Override
    public String toString() {
	return new ToStringBuilder(this)//
	        .append("id", this.id)//
	        .append("evento", this.evento)//
	        .append("crianca", this.crianca)//
	        .append("status", this.status)//
	        .append("resposavel", this.responsavel)//
	        .append("dtResposta", this.dtResposta)//
	        .toString();//
    }

}