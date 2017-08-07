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

    private static final long serialVersionUID = 6970157527141653075L;

    @Valid
    @ApiModelProperty(position = 5, required = true)
    private transient CrecheVo creche;





    public CrecheVo getCreche() {
	return creche;
    }





    public CriancaNovoVO() {
	super();
	this.creche = new CrecheVo();
	this.setPessoa(new PessoaVO());
	this.getPessoa().setEndereco(new EnderecoVO());
	this.setContato(new ContatoVO());
    }
}