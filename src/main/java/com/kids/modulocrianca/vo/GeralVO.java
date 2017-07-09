package com.kids.modulocrianca.vo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.kids.enumeration.Sexo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 *
 */
@ApiModel(description = "geral")
public class GeralVO implements Serializable {

	private static final long serialVersionUID = -5899955521629691704L;

	@ApiModelProperty(position = 0, required = true)
	@NotEmpty(message = "o campo 'matricula' não pode ser vazio")
	@NotNull(message = "o campo 'matricula' é de preenchimento obrigatório")
	@Size(max = 10, message = "o campo 'matricula' deve conter no máximo '10' caracteres")
	private String matricula;

	@ApiModelProperty(position = 1, required = true)
	@NotEmpty(message = "o campo 'nome' não pode ser vazio")
	@NotNull(message = "o campo 'nome' é de preenchimento obrigatório")
	@Size(max = 60, message = "o campo 'nome' deve conter no máximo '60' caracteres")
	private String nome;

	@ApiModelProperty(position = 2, required = true, notes = "yyyy-MM-dd")
	@NotEmpty(message = "o campo 'data de nascimento' não pode ser vazio")
	@NotNull(message = "o campo 'data de nascimento' é de preenchimento obrigatório")
	private String dtNascimento;

	@ApiModelProperty(position = 3, required = true)
	@NotNull(message = "o campo 'sexo' é de preenchimento obrigatório")
	private Sexo sexo;

	@ApiModelProperty(position = 4)
	private String foto;



	public String getMatricula() {
		return matricula;
	}



	public String getNome() {
		return nome;
	}



	public String getDtNascimento() {
		return dtNascimento;
	}



	public Sexo getSexo() {
		return sexo;
	}



	public String getFoto() {
		return foto;
	}
}