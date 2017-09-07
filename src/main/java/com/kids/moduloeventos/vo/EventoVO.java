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
    private Number criancaId;

    @ApiModelProperty(position = 2)
    private String eventoNome;

    @ApiModelProperty(position = 3)
    private String criancaNome;

    @ApiModelProperty(position = 4)
    private String descricao;

    @ApiModelProperty(position = 5)
    private Date dtRealizacao;





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

}