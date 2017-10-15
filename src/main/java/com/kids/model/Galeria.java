package com.kids.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 10/2017
 * 
 */
@Entity
@Table(name = "GALERIA")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Galeria implements Serializable {

    private static final long serialVersionUID = -9839084318351L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_galeria")
    @SequenceGenerator(name = "seq_galeria", sequenceName = "seq_galeria", allocationSize = 100, initialValue = 100)
    private Long id;

    @Column(name = "descricao", length = 60, nullable = false)
    private String descricao;

    @Column(name = "dt_post", nullable = false)
    private LocalDateTime dtPost;

    @Lob
    @Column(name = "imagem", nullable = false)
    private Byte imagem[];

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creche_id", foreignKey = @ForeignKey(name = "FK_creche"), nullable = false)
    private Creche creche;





    public Long getId() {
	return id;
    }





    public void setId(Long id) {
	this.id = id;
    }





    public String getDescricao() {
	return descricao;
    }





    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }





    public LocalDateTime getDtPost() {
	return dtPost;
    }





    public void setDtPost(LocalDateTime dtPost) {
	this.dtPost = dtPost;
    }





    public Byte[] getImagem() {
	return imagem;
    }





    public void setImagem(Byte[] imagem) {
	this.imagem = imagem;
    }





    public Creche getCreche() {
	return creche;
    }





    public void setCreche(Creche creche) {
	this.creche = creche;
    }

}