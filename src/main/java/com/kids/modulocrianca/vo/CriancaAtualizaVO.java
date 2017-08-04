package com.kids.modulocrianca.vo;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 *
 */
public class CriancaAtualizaVO extends CriancaVO {

	@Valid
	@ApiModelProperty(position = 0, required = true)
	private Long id;

	public CriancaAtualizaVO() {
		super();
		this.setPessoa(new PessoaVO());
		this.setEndereco(new EnderecoVO());
		this.setContato(new ContatoVO());
	}

	public Long getId() {
		return id;
	}
}