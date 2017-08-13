package com.kids.model;

import java.io.Serializable;

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
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

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
    @GeneratedValue(generator = "sequenceCriancaFamilia", strategy = GenerationType.TABLE)
    @TableGenerator(name = "sequenceCriancaFamilia", allocationSize = 1)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_crianca")
    private Crianca crianca;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_familia")
    private Familia familia;





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

}