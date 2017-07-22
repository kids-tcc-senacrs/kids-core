package com.kids.modulocrianca.vo;

import javax.validation.Valid;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 *
 */
public class CriancaAtualizaVO extends CriancaVO {

    private static final long serialVersionUID = 7295084283092127744L;

    @Valid
    @ApiModelProperty(position = 0, required = true)
    private Long id;





    public CriancaAtualizaVO() {
	super();
    }





    public Long getId() {
	return id;
    }
}