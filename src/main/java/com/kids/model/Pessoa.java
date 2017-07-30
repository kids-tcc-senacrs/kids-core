package com.kids.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 * 
 */
@Entity
@Table(name = "PESSOA")
public class Pessoa implements Serializable {

    private static final long serialVersionUID = -7055044189565625593L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "sequencePessoa", strategy = GenerationType.TABLE)
    @TableGenerator(name = "sequencePessoa", allocationSize = 1)
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

}