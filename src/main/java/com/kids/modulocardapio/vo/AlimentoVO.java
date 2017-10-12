package com.kids.modulocardapio.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Representa os objetos da tela de cardápio
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 10/2017
 *
 */
@ApiModel(description = "alimento")
public class AlimentoVO implements Serializable {

    private static final long serialVersionUID = 8075939087684286643L;

    @ApiModelProperty(position = 0)
    private Number alimentoId;

    @ApiModelProperty(position = 1)
    private String nome;





    public Number getAlimentoId() {
	return alimentoId;
    }





    public void setAlimentoId(Number alimentoId) {
	this.alimentoId = alimentoId;
    }





    public String getNome() {
	return nome;
    }





    public void setNome(String nome) {
	this.nome = nome;
    }

}