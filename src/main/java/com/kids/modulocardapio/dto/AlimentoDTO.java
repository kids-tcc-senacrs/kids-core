package com.kids.modulocardapio.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 10/2017
 *
 */
@ApiModel(description = "alimento")
public class AlimentoDTO implements Serializable {

    private static final long serialVersionUID = 8111638718831726633L;

    @NotNull(message = "O campo 'alimento' é de preenchimento obrigatório")
    @NotEmpty(message = "O campo 'alimento' é de preenchimento obrigatório")
    @ApiModelProperty(position = 0)
    private String nome;





    public String getNome() {
	return nome;
    }





    public void setNome(String nome) {
	this.nome = nome;
    }

}