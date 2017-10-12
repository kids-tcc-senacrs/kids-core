package com.kids.moduloavaliacao.vo;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Representa os objetos da tela de avaliacoes
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 10/2017
 *
 */
@ApiModel(description = "avaliacao")
public class AvaliacaoVO implements Serializable {

    private static final long serialVersionUID = 1153284720191895233L;

    @ApiModelProperty(position = 0)
    private Number avaliacaoId;

    @ApiModelProperty(position = 1)
    private String crecheNome;

    @ApiModelProperty(position = 2)
    private String criancaNome;

    @ApiModelProperty(position = 3)
    private String descricao;

    @ApiModelProperty(position = 4)
    private Date dtAvaliacao;





    public Number getAvaliacaoId() {
	return avaliacaoId;
    }





    public void setAvaliacaoId(Number avaliacaoId) {
	this.avaliacaoId = avaliacaoId;
    }





    public String getCrecheNome() {
	return crecheNome;
    }





    public void setCrecheNome(String crecheNome) {
	this.crecheNome = crecheNome;
    }





    public String getCriancaNome() {
	return criancaNome;
    }





    public void setCriancaNome(String criancaNome) {
	this.criancaNome = criancaNome;
    }





    public String getDescricao() {
	return descricao;
    }





    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }





    public Date getDtAvaliacao() {
	return dtAvaliacao;
    }





    public void setDtAvaliacao(Date dtAvaliacao) {
	this.dtAvaliacao = dtAvaliacao;
    }

}