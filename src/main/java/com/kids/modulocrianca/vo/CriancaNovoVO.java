package com.kids.modulocrianca.vo;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 * 
 */
public class CriancaNovoVO extends CriancaVO {

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
		this.setEndereco(new EnderecoVO());
		this.setContato(new ContatoVO());
	}
}