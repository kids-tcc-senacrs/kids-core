package com.kids.modulocrianca.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 * 
 */
@ApiModel(description = "contato")
public class ContatoVO {

	@ApiModelProperty(position = 0, required = true)
	@NotEmpty(message = "o campo 'responsavel' não pode ser vazio")
	@NotNull(message = "o campo 'responsavel' é de preenchimento obrigatório")
	@Size(max = 60, message = "o campo 'responsavel' deve conter no máximo '60' caracteres")
	private String responsavel;

	@ApiModelProperty(position = 1, required = true, example = "email@email.com")
	@Email(message = "o 'email' informado não é um endereço de email valido")
	@NotEmpty(message = "o campo 'email' não pode ser vazio")
	@NotNull(message = "o campo 'email' é de preenchimento obrigatório")
	@Size(max = 255, message = "o campo 'email' deve conter no máximo '255' caracteres")
	private String email;

	@ApiModelProperty(position = 2, required = true)
	@NotEmpty(message = "o campo 'fone principal' não pode ser vazio")
	@NotNull(message = "o campo 'fone principal' é de preenchimento obrigatório")
	@Size(max = 20, message = "o campo 'fone principal' deve conter no máximo '20' caracteres")
	private String fonePrincipal;

	@ApiModelProperty(position = 3)
	@Size(max = 20, message = "o campo 'fone outro' deve conter no máximo '20' caracteres")
	private String foneOutro;

	public ContatoVO() {
		super();
	}

	public String getResponsavel() {
		return responsavel;
	}

	public String getEmail() {
		return email;
	}

	public String getFonePrincipal() {
		return fonePrincipal;
	}

	public String getFoneOutro() {
		return foneOutro;
	}
}