package com.kids.model;

import java.io.Serializable;
import java.time.LocalDateTime;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.kids.enumeration.ComunicacaoTipo;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 09/2017
 * 
 */
@Entity
@Table(name = "COMUNICACAO")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Comunicacao implements Serializable {

    private static final long serialVersionUID = 1977147368182768604L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_comunicacao")
    @SequenceGenerator(name = "seq_comunicacao", sequenceName = "seq_comunicacao", allocationSize = 100, initialValue = 100)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false, foreignKey = @ForeignKey(name = "FK_usuario"))
    private Usuario usuario;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_creche", nullable = false, foreignKey = @ForeignKey(name = "FK_creche"))
    private Creche creche;

    @Column(name = "descricao_familiar", nullable = false, length = 500)
    private String descricaoFamiliar;

    @Column(name = "descricao_creche", nullable = true, length = 200)
    private String descricaoCreche;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false, length = 10)
    private ComunicacaoTipo tipo;

    @Column(name = "dt_envio_familiar", nullable = false)
    private LocalDateTime dtEnvioFamiliar;

    @Column(name = "dt_resposta_creche", nullable = true)
    private LocalDateTime dtRespostaCreche;

    @Column(name = "creche_respondeu", nullable = false)
    private Boolean crecheRespondeu;





    public Long getId() {
	return id;
    }





    public void setId(Long id) {
	this.id = id;
    }





    public Usuario getUsuario() {
	return usuario;
    }





    public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
    }





    public Creche getCreche() {
	return creche;
    }





    public void setCreche(Creche creche) {
	this.creche = creche;
    }





    public String getDescricaoFamiliar() {
	return descricaoFamiliar;
    }





    public void setDescricaoFamiliar(String descricaoFamiliar) {
	this.descricaoFamiliar = descricaoFamiliar;
    }





    public String getDescricaoCreche() {
	return descricaoCreche;
    }





    public void setDescricaoCreche(String descricaoCreche) {
	this.descricaoCreche = descricaoCreche;
    }





    public ComunicacaoTipo getTipo() {
	return tipo;
    }





    public void setTipo(ComunicacaoTipo tipo) {
	this.tipo = tipo;
    }





    public Boolean getCrecheRespondeu() {
	return crecheRespondeu;
    }





    public void setCrecheRespondeu(Boolean crecheRespondeu) {
	this.crecheRespondeu = crecheRespondeu;
    }





    public LocalDateTime getDtEnvioFamiliar() {
	return dtEnvioFamiliar;
    }





    public void setDtEnvioFamiliar(LocalDateTime dtEnvioFamiliar) {
	this.dtEnvioFamiliar = dtEnvioFamiliar;
    }





    public LocalDateTime getDtRespostaCreche() {
	return dtRespostaCreche;
    }





    public void setDtRespostaCreche(LocalDateTime dtRespostaCreche) {
	this.dtRespostaCreche = dtRespostaCreche;
    }

}