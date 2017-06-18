package com.kids.moduloautorizacao.vo;

import java.io.Serializable;

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

	@ApiModelProperty(required = true, position = 0)
	@NotNull(message = "o campo 'id' é de preenchimento obrigatório")
	private Long id;

	@ApiModelProperty(required = true, position = 1)
	@Size(max = 60, message = "o campo 'nome' deve conter no máximo '60' caracteres")
	@NotNull(message = "o campo 'nome' é de preenchimento obrigatório")
	@NotEmpty(message = "o campo 'nome' não pode ser vazio")
	private String nome;

	@ApiModelProperty(position = 2)
	@Size(max = 20, message = "o campo 'telefone' deve conter no máximo '20' caracteres")
	private String telefone;

	@ApiModelProperty(position = 3)
	private boolean ativo;

	@ApiModelProperty(position = 4)
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
		@Size(max = 100, message = "o campo 'complemento' deve conter no máximo '100' caracteres")
		private String complemento;



		public String getCep() {
			return cep;
		}



		public String getLogradouro() {
			return logradouro;
		}



		public String getComplemento() {
			return complemento;
		}
	}



	public Long getId() {
		return id;
	}



	public String getNome() {
		return nome;
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