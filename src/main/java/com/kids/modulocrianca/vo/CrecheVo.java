package com.kids.modulocrianca.vo;

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
public class CrecheVo {

    @ApiModelProperty(position = 0, required = true)
    @NotNull(message = "o campo 'crecheId' é de preenchimento obrigatório")
    private Long id;





    public Long getId() {
	return id;
    }





    public void setId(final Long id) {
	this.id = id;
    }

}