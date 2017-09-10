package com.kids.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "FAMILIA")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Familia implements Serializable {

    private static final long serialVersionUID = 8164369067802692420L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_familia")
    @SequenceGenerator(name = "seq_familia", sequenceName = "seq_familia", allocationSize = 1)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa", nullable = false, unique = true, foreignKey = @ForeignKey(name = "FK_pessoa"))
    private Pessoa pessoa;





    public Familia(final Pessoa pessoa) {
	super();
	this.pessoa = pessoa;
    }





    public Familia() {
	super();
    }





    public Long getId() {
	return id;
    }





    public void setId(final Long id) {
	this.id = id;
    }





    public Pessoa getPessoa() {
	return pessoa;
    }





    public void setPessoa(final Pessoa pessoa) {
	this.pessoa = pessoa;
    }





    @Override
    public String toString() {
	return new ToStringBuilder(this)//
	        .append("id", this.id)//
	        .append("pessoa", this.pessoa)//
	        .toString();//
    }

}