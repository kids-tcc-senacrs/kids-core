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
@ApiModel(description = "resposta_evento")
public class RespostaEventoVO implements Serializable {

    private static final long serialVersionUID = -1951783166619495076L;

    @ApiModelProperty(position = 0)
    private String eventoNome;

    @ApiModelProperty(position = 1)
    private String crecheNome;

    @ApiModelProperty(position = 2)
    private String criancaNome;

    @ApiModelProperty(position = 3)
    private Date dtRealizacao;





    public String getEventoNome() {
	return eventoNome;
    }





    public void setEventoNome(String eventoNome) {
	this.eventoNome = eventoNome;
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





    public Date getDtRealizacao() {
	return dtRealizacao;
    }





    public void setDtRealizacao(Date dtRealizacao) {
	this.dtRealizacao = dtRealizacao;
    }

}