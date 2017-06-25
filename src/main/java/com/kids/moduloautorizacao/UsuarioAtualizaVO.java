package com.kids.moduloautorizacao;

import java.io.Serializable;

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
public class UsuarioAtualizaVO implements Serializable {

	private static final long serialVersionUID = -4250740341959384029L;

	@ApiModelProperty(position = 0, required = true)
	@NotNull(message = "o campo 'id' é de preenchimento obrigatório")
	private Long id;

	@ApiModelProperty(position = 1, required = true)
	@NotEmpty(message = "o campo 'telefone' não pode ser vazio")
	@NotNull(message = "o campo 'telefone' é de preenchimento obrigatório")
	@Size(min = 8, max = 20, message = "o campo 'telefone' deve conter entre '8 e 20' caracteres")
	private String telefone;

	@ApiModelProperty(position = 2)
	private boolean ativo;

	@Valid
	@ApiModelProperty(position = 3, required = true)
	private EnderecoVO endereco;

	@ApiModel(description = "endereco")
	public class EnderecoVO {

		@ApiModelProperty(position = 0, required = true)
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



	public Long getId() {
		return id;
	}



	public String getTelefone() {
		return telefone;
	}



	public boolean isAtivo() {
		return ativo;
	}



	public EnderecoVO getEndereco() {
		return endereco;
	}
	
}