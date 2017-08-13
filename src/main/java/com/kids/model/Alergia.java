package com.kids.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 * 
 */
@Entity
@Table(name = "ALERGIA")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Alergia implements Serializable {

    private static final long serialVersionUID = 8433449795250662499L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "sequenceAlergia", strategy = GenerationType.TABLE)
    @TableGenerator(name = "sequenceAlergia", allocationSize = 1)
    private Long id;

    @Column(name = "descricao", length = 50)
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





    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
	return result;
    }





    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Alergia other = (Alergia) obj;
	if (descricao == null) {
	    if (other.descricao != null)
		return false;
	} else if (!descricao.equals(other.descricao))
	    return false;
	return true;
    }





    @Override
    public String toString() {
	return new ToStringBuilder(this)//
	        .append("id", this.id)//
	        .append("descricao", this.descricao)//
	        .toString();//
    }

}