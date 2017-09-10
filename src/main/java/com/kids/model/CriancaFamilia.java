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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.kids.enumeration.Parentesco;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 08/2017
 *
 */
@Entity
@Table(name = "CRIANCA_FAMILIA", uniqueConstraints = @UniqueConstraint(columnNames = { "id_crianca", "id_familia" }, name = "UQ_CRIANCA_FAMILIA"))
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class CriancaFamilia implements Serializable {

    private static final long serialVersionUID = -3332470824920523382L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_criancaFamilia")
    @SequenceGenerator(name = "seq_criancaFamilia", sequenceName = "seq_criancaFamilia", allocationSize = 1)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_crianca", nullable = false)
    private Crianca crianca;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_familia", nullable = false)
    private Familia familia;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    @Column(name = "parentesco", nullable = false)
    private Parentesco parentesco;

    @Column(name = "dt_vinculo", nullable = false)
    private LocalDateTime dtVinculo;

    @Column(name = "ativo", nullable = false)
    private Boolean ativo;

    @Column(name = "familiar_notificado", nullable = false)
    private Boolean familiarNotificado;





    public Long getId() {
	return id;
    }





    public void setId(final Long id) {
	this.id = id;
    }





    public Crianca getCrianca() {
	return crianca;
    }





    public void setCrianca(final Crianca crianca) {
	this.crianca = crianca;
    }





    public Familia getFamilia() {
	return familia;
    }





    public void setFamilia(final Familia familia) {
	this.familia = familia;
    }





    public Parentesco getParentesco() {
	return parentesco;
    }





    public void setParentesco(final Parentesco parentesco) {
	this.parentesco = parentesco;
    }





    public LocalDateTime getDtVinculo() {
	return dtVinculo;
    }





    public void setDtVinculo(final LocalDateTime dtVinculo) {
	this.dtVinculo = dtVinculo;
    }





    public Boolean getFamiliarNotificado() {
	return familiarNotificado;
    }





    public void setFamiliarNotificado(final Boolean familiarNotificado) {
	this.familiarNotificado = familiarNotificado;
    }





    public Boolean getAtivo() {
	return ativo;
    }





    public void setAtivo(final Boolean ativo) {
	this.ativo = ativo;
    }





    public Usuario getUsuario() {
	return usuario;
    }





    public void setUsuario(final Usuario usuario) {
	this.usuario = usuario;
    }

}