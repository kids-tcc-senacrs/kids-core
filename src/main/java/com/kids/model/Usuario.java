package com.kids.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.kids.enumeration.TipoUsuario;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 05/2017
 * 
 */
@Entity
@Table(name = "USUARIO")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Usuario implements Serializable {

    private static final long serialVersionUID = -2561353904338124908L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "sequenceUsuario", strategy = GenerationType.TABLE)
    @TableGenerator(name = "sequenceUsuario", allocationSize = 1)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "id_pessoa", nullable = false, foreignKey = @ForeignKey(name = "FK_pessoa"))
    private Pessoa pessoa;

    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "telefone", nullable = true, length = 20)
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false, length = 8)
    private TipoUsuario tipo;

    @Column(name = "ativo", nullable = false)
    private Boolean ativo;





    public Usuario() {
	super();
	this.setPessoa(new Pessoa());
    }





    public Usuario(final String email) {
	super();
	this.email = email;
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





    public String getEmail() {
	return email;
    }





    public void setEmail(final String email) {
	this.email = email;
    }





    public String getTelefone() {
	return telefone;
    }





    public void setTelefone(final String telefone) {
	this.telefone = telefone;
    }





    public TipoUsuario getTipo() {
	return tipo;
    }





    public void setTipo(final TipoUsuario tipo) {
	this.tipo = tipo;
    }





    public Boolean getAtivo() {
	return ativo;
    }





    public void setAtivo(final Boolean ativo) {
	this.ativo = ativo;
    }





    @Override
    public String toString() {
	return new ToStringBuilder(this)//
	        .append("id", this.id)//
	        .append("pessoa", this.pessoa)//
	        .append("email", this.email)//
	        .append("telefone", this.telefone)//
	        .append("tipo", this.tipo).toString();//
    }

}