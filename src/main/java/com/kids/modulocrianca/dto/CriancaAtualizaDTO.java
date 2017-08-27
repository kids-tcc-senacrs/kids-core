package com.kids.modulocrianca.dto;

import javax.validation.Valid;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 *
 */
public class CriancaAtualizaDTO extends CriancaDTO {

    private static final long serialVersionUID = 1310079520043873124L;

    @Valid
    @ApiModelProperty(position = 0, required = true)
    private Long id;





    public CriancaAtualizaDTO() {
	super();
	this.setPessoa(new PessoaDTO());
	this.getPessoa().setEndereco(new EnderecoDTO());
	this.setContato(new ContatoDTO());
    }





    public Long getId() {
	return id;
    }
}