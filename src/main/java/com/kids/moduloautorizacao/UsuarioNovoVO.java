package com.kids.moduloautorizacao;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.kids.enumeration.TipoUsuario;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 05/2017
 * 
 */
@ApiModel(description = "usuario")
public class UsuarioNovoVO implements Serializable {

	private static final long serialVersionUID = -4250740341959384029L;

	@ApiModelProperty(position = 0, required = true)
	@NotEmpty(message = "o campo 'nome' não pode ser vazio")
	@NotNull(message = "o campo 'nome' é de preenchimento obrigatório")
	@Size(max = 60, message = "o campo 'nome' deve conter no máximo '60' caracteres")
	private String nome;

	@ApiModelProperty(position = 1, required = true)
	@Email(message = "o 'email' informado não é um endereço de email valido")
	@NotEmpty(message = "o campo 'email' não pode ser vazio")
	@NotNull(message = "o campo 'email' é de preenchimento obrigatório")
	@Size(max = 255, message = "o campo 'email' deve conter no máximo '255' caracteres")
	private String email;

	@ApiModelProperty(position = 2)
	@Size(max = 20, message = "o campo 'telefone' deve conter no máximo '20' caracteres")
	private String telefone;

	@ApiModelProperty(position = 3, required = true)
	@NotNull(message = "o campo 'tipo' é de preenchimento obrigatório")
	private TipoUsuario tipo;



	public String getNome() {
		return nome;
	}



	public String getEmail() {
		return email;
	}



	public String getTelefone() {
		return telefone;
	}



	public TipoUsuario getTipo() {
		return tipo;
	}
}