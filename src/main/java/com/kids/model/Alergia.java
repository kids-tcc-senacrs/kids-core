package com.kids.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 * 
 */
@Entity
@Table(name = "ALERGIA")
public class Alergia implements Serializable {

    private static final long serialVersionUID = 8433449795250662499L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "sequenceAlergia", strategy = GenerationType.TABLE)
    @TableGenerator(name = "sequenceAlergia", allocationSize = 1)
    private Long id;

    @Column(name = "descricao", length = 60)
    private String descricao;





    public Alergia() {
	super();
    }





    public Long getId() {
	return id;
    }





    public void setId(final Long id) {
	this.id = id;
    }





    public String getDescricao() {
	return descricao;
    }





    public void setDescricao(final String descricao) {
	this.descricao = descricao;
    }
}
