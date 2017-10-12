package com.kids.modulocardapio.vo;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Representa os objetos da tela de cardápio
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 10/2017
 *
 */
@ApiModel(description = "cardapio")
public class CardapioVO implements Serializable {

    private static final long serialVersionUID = 8075939087684286643L;

    @ApiModelProperty(position = 0)
    private Number cardapioId;

    @ApiModelProperty(position = 1)
    private String crecheNome;

    @ApiModelProperty(position = 2)
    private String diaSemana;

    @ApiModelProperty(position = 3)
    private Date dtCardapio;





    public Number getCardapioId() {
	return cardapioId;
    }





    public void setCardapioId(final Number cardapioId) {
	this.cardapioId = cardapioId;
    }





    public String getCrecheNome() {
	return crecheNome;
    }





    public void setCrecheNome(final String crecheNome) {
	this.crecheNome = crecheNome;
    }





    public String getDiaSemana() {
	return diaSemana;
    }





    public void setDiaSemana(final String diaSemana) {
	this.diaSemana = diaSemana;
    }





    public Date getDtCardapio() {
	return dtCardapio;
    }





    public void setDtCardapio(final Date dtCardapio) {
	this.dtCardapio = dtCardapio;
    }

}