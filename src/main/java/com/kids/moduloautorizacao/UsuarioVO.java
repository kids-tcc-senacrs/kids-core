package com.kids.moduloautorizacao;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
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
public class UsuarioVO implements Serializable {

	private static final long serialVersionUID = -4250740341959384029L;

	@ApiModelProperty(required = true, position = 0)
	@Size(max = 60, message = "o campo 'nome' deve conter no máximo '60' caracteres")
	@NotNull(message = "o campo 'nome' é de preenchimento obrigatório")
	@NotEmpty(message = "o campo 'nome' não pode ser vazio")
	private String nome;

	@ApiModelProperty(position = 1)
	@Size(max = 30, message = "o campo 'apelido' deve conter no máximo '30' caracteres")
	private String apelido;

	@ApiModelProperty(required = true, position = 2)
	@Email(message = "o 'email' informado não é um endereço de email valido")
	@Size(max = 120, message = "o campo 'email' deve conter no máximo '120' caracteres")
	@NotNull(message = "o campo 'email' é de preenchimento obrigatório")
	@NotEmpty(message = "o campo 'email' não pode ser vazio")
	private String email;

	@ApiModelProperty(position = 3)
	@Size(max = 20, message = "o campo 'telefone' deve conter no máximo '20' caracteres")
	private String telefone;

	@ApiModelProperty(position = 4)
	@Size(max = 300, message = "o campo 'fotoUrl' deve conter no máximo '300' caracteres")
	private String fotoUrl;

	@ApiModelProperty(required = true, allowableValues = "CRECHE, FAMILIAR", position = 5)
	@NotNull(message = "o campo 'tipo' é de preenchimento obrigatório")
	private String tipo;

	@ApiModelProperty(position = 6)
	private EnderecoVO endereco;

	@ApiModel(description = "endereco")
	public class EnderecoVO {

		@ApiModelProperty(position = 0)
		@Size(max = 8, message = "o campo 'cep' deve conter no máximo '8' caracteres")
		private String cep;

		@ApiModelProperty(position = 1)
		@Size(max = 80, message = "o campo 'logradouro' deve conter no máximo '80' caracteres")
		private String logradouro;

		@ApiModelProperty(position = 2)
		@Size(max = 30, message = "o campo 'bairro' deve conter no máximo '30' caracteres")
		private String bairro;

		@ApiModelProperty(position = 3)
		@Size(max = 60, message = "o campo 'cidade' deve conter no máximo '60' caracteres")
		private String cidade;

		@ApiModelProperty(required = true, allowableValues = "RS, RJ, SP, SC", position = 4)
		private String estado;

		public String getCep() {
			return cep;
		}

		public String getLogradouro() {
			return logradouro;
		}

		public String getBairro() {
			return bairro;
		}

		public String getCidade() {
			return cidade;
		}

		public String getEstado() {
			return estado;
		}

	}

	public String getNome() {
		return nome;
	}

	public String getApelido() {
		return apelido;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getFotoUrl() {
		return fotoUrl;
	}

	public String getTipo() {
		return tipo;
	}

	public EnderecoVO getEndereco() {
		return endereco;
	}
}