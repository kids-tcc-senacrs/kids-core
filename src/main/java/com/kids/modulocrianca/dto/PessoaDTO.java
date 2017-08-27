package com.kids.modulocrianca.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "pessoa")
public class PessoaDTO {

    @ApiModelProperty(position = 0, required = true)
    @NotEmpty(message = "o campo 'nome' não pode ser vazio")
    @NotNull(message = "o campo 'nome' é de preenchimento obrigatório")
    @Size(max = 60, message = "o campo 'nome' deve conter no máximo '60' caracteres")
    private String nome;

    @Valid
    @ApiModelProperty(position = 1, required = true)
    private transient EnderecoDTO endereco;





    public String getNome() {
	return nome;
    }





    public void setNome(final String nome) {
	this.nome = nome;
    }





    public EnderecoDTO getEndereco() {
	return endereco;
    }





    public void setEndereco(final EnderecoDTO endereco) {
	this.endereco = endereco;
    }

}