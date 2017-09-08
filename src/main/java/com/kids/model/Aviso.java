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

import com.kids.enumeration.AvisoOrigem;

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
    @Column(name = "origem", length = 6, nullable = false)
    private AvisoOrigem origem;





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





    public AvisoOrigem getOrigem() {
	return origem;
    }





    public void setOrigem(AvisoOrigem origem) {
	this.origem = origem;
    }

}