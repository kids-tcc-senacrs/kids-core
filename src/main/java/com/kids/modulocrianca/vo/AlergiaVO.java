package com.kids.modulocrianca.vo;

import java.io.Serializable;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 * 
 */
@ApiModel(description = "alergia")
public class AlergiaVO implements Serializable {

	private static final long serialVersionUID = -5088394951428811478L;

	@ApiModelProperty(position = 0, required = true)
	@Size(max = 60, message = "o campo 'descricao' deve conter no máximo '60' caracteres")
	private String descricao;



	public AlergiaVO() {
		super();
	}



	public String getDescricao() {
		return descricao;
	}
}