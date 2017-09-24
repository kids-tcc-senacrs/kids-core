package com.kids.modulocrianca.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 09/2017
 * 
 */
@ApiModel(description = "creche")
public class CrecheVO {

    @ApiModelProperty(position = 0, required = true)
    private Number id;

    @ApiModelProperty(position = 2, required = true)
    private String nome;





    public Number getId() {
	return id;
    }





    public void setId(Number id) {
	this.id = id;
    }





    public String getNome() {
	return nome;
    }





    public void setNome(String nome) {
	this.nome = nome;
    }

}