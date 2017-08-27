package com.kids.modulocrianca.dto;

import javax.validation.Valid;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 * 
 */
public class CriancaNovoDTO extends CriancaDTO {

    private static final long serialVersionUID = 6970157527141653075L;

    @Valid
    @ApiModelProperty(position = 5, required = true)
    private transient CrecheDTO creche;





    public CrecheDTO getCreche() {
	return creche;
    }





    public CriancaNovoDTO() {
	super();
	this.creche = new CrecheDTO();
	this.setPessoa(new PessoaDTO());
	this.getPessoa().setEndereco(new EnderecoDTO());
	this.setContato(new ContatoDTO());
    }
}