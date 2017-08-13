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
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 05/2017
 * 
 */
@Entity
@Table(name = "ENDERECO")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Endereco implements Serializable {

    private static final long serialVersionUID = 7505989989856840679L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "sequenceEndereco", strategy = GenerationType.TABLE)
    @TableGenerator(name = "sequenceEndereco", allocationSize = 1)
    private Long id;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa", foreignKey = @ForeignKey(name = "FK_pessoa"))
    private Pessoa pessoa;

    @Column(name = "cep", length = 8, nullable = false)
    private String cep;

    @Column(name = "logradouro", length = 60, nullable = false)
    private String logradouro;

    @Column(name = "localizacao", length = 120, nullable = false)
    private String localizacao;





    public Endereco() {
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





    public String getCep() {
	return cep;
    }





    public void setCep(final String cep) {
	this.cep = cep;
    }





    public String getLogradouro() {
	return logradouro;
    }





    public void setLogradouro(final String logradouro) {
	this.logradouro = logradouro;
    }





    public String getLocalizacao() {
	return localizacao;
    }





    public void setLocalizacao(final String localizacao) {
	this.localizacao = localizacao;
    }





    @Override
    public String toString() {
	return new ToStringBuilder(this)//
	        .append("id", this.id)//
	        .append("pessoa", this.pessoa)//
	        .toString();//
    }
}