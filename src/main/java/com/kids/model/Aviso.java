package com.kids.model;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.kids.enumeration.AvisoTipo;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 09/2017
 * 
 */
@Entity
@Table(name = "AVISO")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Aviso implements Serializable {

    private static final long serialVersionUID = 8433449795250662499L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "sequenceEvento", strategy = GenerationType.TABLE)
    @TableGenerator(name = "sequenceEvento", allocationSize = 1)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_creche", nullable = false)
    private Creche creche;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_expiracao", nullable = false)
    private Date dtExpiracao;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", length = 12, nullable = false)
    private AvisoTipo tipo;





    public Long getId() {
	return id;
    }





    public void setId(Long id) {
	this.id = id;
    }





    public Creche getCreche() {
	return creche;
    }





    public void setCreche(Creche creche) {
	this.creche = creche;
    }





    public String getDescricao() {
	return descricao;
    }





    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }





    public Date getDtExpiracao() {
	return dtExpiracao;
    }





    public void setDtExpiracao(Date dtExpiracao) {
	this.dtExpiracao = dtExpiracao;
    }





    public AvisoTipo getTipo() {
	return tipo;
    }





    public void setTipo(AvisoTipo tipo) {
	this.tipo = tipo;
    }





    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
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
	Aviso other = (Aviso) obj;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	return true;
    }

}