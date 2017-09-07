package com.kids.moduloeventos.vo;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Representa os objetos da tela de eventos
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 09/2017
 *
 */
@ApiModel(description = "evento")
public class EventoVO implements Serializable {

    private static final long serialVersionUID = -1951783166619495076L;

    @ApiModelProperty(position = 0)
    private Number eventoId;

    @ApiModelProperty(position = 1)
    private String eventoNome;

    @ApiModelProperty(position = 2)
    private String descricao;

    @ApiModelProperty(position = 3)
    private String crecheNome;

    @ApiModelProperty(position = 4)
    private String crecheLogradouro;

    @ApiModelProperty(position = 5)
    private String crecheLocalizacao;

    @ApiModelProperty(position = 6)
    private Number criancaId;

    @ApiModelProperty(position = 7)
    private String criancaNome;

    @ApiModelProperty(position = 8)
    private Date dtRealizacao;

    @ApiModelProperty(position = 9)
    private String pessoaUserResposta;





    public Number getEventoId() {
	return eventoId;
    }





    public void setEventoId(Number eventoId) {
	this.eventoId = eventoId;
    }





    public Number getCriancaId() {
	return criancaId;
    }





    public void setCriancaId(Number criancaId) {
	this.criancaId = criancaId;
    }





    public String getEventoNome() {
	return eventoNome;
    }





    public void setEventoNome(String eventoNome) {
	this.eventoNome = eventoNome;
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





    public Date getDtRealizacao() {
	return dtRealizacao;
    }





    public void setDtRealizacao(Date dtRealizacao) {
	this.dtRealizacao = dtRealizacao;
    }





    public String getCrecheNome() {
	return crecheNome;
    }





    public void setCrecheNome(String crecheNome) {
	this.crecheNome = crecheNome;
    }





    public String getCrecheLogradouro() {
	return crecheLogradouro;
    }





    public void setCrecheLogradouro(String crecheLogradouro) {
	this.crecheLogradouro = crecheLogradouro;
    }





    public String getCrecheLocalizacao() {
	return crecheLocalizacao;
    }





    public void setCrecheLocalizacao(final String crecheLocalizacao) {
	this.crecheLocalizacao = crecheLocalizacao;
    }





    public String getPessoaUserResposta() {
	return pessoaUserResposta;
    }





    public void setPessoaUserResposta(String pessoaUserResposta) {
	this.pessoaUserResposta = pessoaUserResposta;
    }

}