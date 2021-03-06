package com.kids.modulocrianca.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 * 
 */
@ApiModel(description = "endereco")
public class EnderecoDTO {

	@ApiModelProperty(position = 0, required = true, example = "12345678")
	@NotEmpty(message = "o campo 'cep' não pode ser vazio")
	@NotNull(message = "o campo 'cep' é de preenchimento obrigatório")
	@Size(min = 8, max = 8, message = "o campo 'cep' deve conter '8' caracteres")
	private String cep;

	@ApiModelProperty(position = 1, required = true)
	@NotEmpty(message = "o campo 'logradouro' não pode ser vazio")
	@NotNull(message = "o campo 'logradouro' é de preenchimento obrigatório")
	@Size(max = 60, message = "o campo 'logradouro' deve conter no máximo '60' caracteres")
	private String logradouro;

	@ApiModelProperty(position = 2, required = true)
	@NotEmpty(message = "o campo 'localizacao' não pode ser vazio")
	@NotNull(message = "o campo 'localizacao' é de preenchimento obrigatório")
	@Size(max = 120, message = "o campo 'complemento' deve conter no máximo '120' caracteres")
	private String localizacao;

	public EnderecoDTO() {
		super();
	}

	public String getCep() {
		return cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getLocalizacao() {
		return localizacao;
	}
}