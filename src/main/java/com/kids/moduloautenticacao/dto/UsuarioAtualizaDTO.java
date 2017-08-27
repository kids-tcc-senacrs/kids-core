package com.kids.moduloautenticacao.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 05/2017
 * 
 */
@ApiModel(description = "usuario")
public class UsuarioAtualizaDTO {

    @ApiModelProperty(position = 0, required = true)
    @NotNull(message = "o campo 'id' é de preenchimento obrigatório")
    private Long id;

    @ApiModelProperty(position = 1, required = true, example = "12345678")
    @NotEmpty(message = "o campo 'telefone' não pode ser vazio")
    @NotNull(message = "o campo 'telefone' é de preenchimento obrigatório")
    @Size(min = 8, max = 20, message = "o campo 'telefone' deve conter entre '8 e 20' caracteres")
    private String telefone;

    @ApiModelProperty(position = 2)
    private boolean ativo;

    @Valid
    @ApiModelProperty(position = 3, required = true)
    private transient PessoaDTO pessoa;





    public Long getId() {
	return id;
    }





    public String getTelefone() {
	return telefone;
    }





    public boolean isAtivo() {
	return ativo;
    }





    public PessoaDTO getPessoa() {
	return pessoa;
    }
}