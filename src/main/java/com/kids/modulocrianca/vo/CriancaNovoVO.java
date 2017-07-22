package com.kids.modulocrianca.vo;

import javax.validation.Valid;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 * 
 */
public class CriancaNovoVO extends CriancaVO {

    private static final long serialVersionUID = 1151158807162355791L;

    @Valid
    @ApiModelProperty(position = 5, required = true)
    private CrecheVo creche;





    public CrecheVo getCreche() {
	return creche;
    }





    public CriancaNovoVO() {
	super();
    }
}