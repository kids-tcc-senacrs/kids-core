package com.kids.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 * 
 */
@Entity
@Table(name = "PESSOA")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Pessoa implements Serializable {

    private static final long serialVersionUID = -7055044189565625593L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa")
    @SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa", allocationSize = 1)
    private Long id;

    @Column(name = "nome", nullable = false, length = 60)
    private String nome;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "pessoa")
    private Endereco endereco;





    public Pessoa() {
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





    public Endereco getEndereco() {
	return endereco;
    }





    public void setEndereco(final Endereco endereco) {
	this.endereco = endereco;
    }





    @Override
    public String toString() {
	return new ToStringBuilder(this)//
	        .append("id", this.id)//
	        .append("nome", this.nome)//
	        .append("endereco", this.endereco)//
	        .toString();//
    }
}