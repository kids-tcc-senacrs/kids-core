package com.kids.modulocrianca.vo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "pessoa")
public class PessoaVO implements Serializable {

    private static final long serialVersionUID = 6606997475305489635L;

    @ApiModelProperty(position = 0, required = true)
    @NotEmpty(message = "o campo 'nome' não pode ser vazio")
    @NotNull(message = "o campo 'nome' é de preenchimento obrigatório")
    @Size(max = 60, message = "o campo 'nome' deve conter no máximo '60' caracteres")
    private String nome;





    public String getNome() {
	return nome;
    }





    public void setNome(final String nome) {
	this.nome = nome;
    }

}