package com.kids.modulocrianca.vo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 * 
 */
@ApiModel(description = "creche")
public class CrecheVo implements Serializable {

	private static final long serialVersionUID = -3725043142340838639L;

	@ApiModelProperty(position = 0, required = true)
	@NotNull(message = "o campo 'id' é de preenchimento obrigatório")
	private Long id;



	public Long getId() {
		return id;
	}



	public void setId(final Long id) {
		this.id = id;
	}
}