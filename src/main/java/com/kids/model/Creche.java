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

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 * 
 */
@Entity
@Table(name = "CRECHE")
public class Creche implements Serializable {

    private static final long serialVersionUID = 8164369067802692420L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "sequenceCreche", strategy = GenerationType.TABLE)
    @TableGenerator(name = "sequenceCreche", allocationSize = 1)
    private Long id;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa", nullable = false, unique = true, foreignKey = @ForeignKey(name = "FK_pessoa"))
    private Pessoa pessoa;





    public Creche(final Pessoa pessoa) {
	super();
	this.pessoa = pessoa;
    }





    public Creche() {
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
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
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
	Creche other = (Creche) obj;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	if (pessoa == null) {
	    if (other.pessoa != null)
		return false;
	} else if (!pessoa.equals(other.pessoa))
	    return false;
	return true;
    }





    @Override
    public String toString() {
	return new ToStringBuilder(this)//
	        .append("id", this.id)//
	        .append("pessoa", this.pessoa)//
	        .toString();//
    }
}