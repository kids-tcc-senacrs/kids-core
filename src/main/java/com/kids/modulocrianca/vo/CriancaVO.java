package com.kids.modulocrianca.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;
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
@ApiModel(description = "crianca")
public class CriancaVO implements Serializable {

	private static final long serialVersionUID = 8182810973491330809L;

	@ApiModelProperty(position = 0, required = true)
	@NotEmpty(message = "o campo 'matricula' não pode ser vazio")
	@NotNull(message = "o campo 'matricula' é de preenchimento obrigatório")
	@Size(max = 10, message = "o campo 'matricula' deve conter no máximo '10' caracteres")
	private String matricula;

	@ApiModelProperty(position = 1, required = true, notes = "yyyy-MM-dd")
	@NotEmpty(message = "o campo 'data de nascimento' não pode ser vazio")
	@NotNull(message = "o campo 'data de nascimento' é de preenchimento obrigatório")
	private String dtNascimento;

	@ApiModelProperty(position = 2)
	private Sexo sexo;

	@ApiModelProperty(position = 3)
	private Byte foto[];

	@Valid
	@ApiModelProperty(position = 4, required = true)
	private PessoaVO pessoa;

	@Valid
	@ApiModelProperty(position = 5, required = true)
	private EnderecoVO endereco;

	@Valid
	@ApiModelProperty(position = 6, required = true)
	private ContatoVO contato;

	@Valid
	@ApiModelProperty(position = 7)
	private Set<MedicamentoVO> medicamentos;

	@Valid
	@ApiModelProperty(position = 8)
	private Set<AlergiaVO> alergias;

	public CriancaVO() {
		super();
		this.alergias = new HashSet<>();
	}

	public PessoaVO getPessoa() {
		return pessoa;
	}

	public void setPessoa(final PessoaVO pessoa) {
		this.pessoa = pessoa;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(final String matricula) {
		this.matricula = matricula;
	}

	public String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(final String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(final Sexo sexo) {
		this.sexo = sexo;
	}

	public Byte[] getFoto() {
		return foto;
	}

	public void setFoto(final Byte[] foto) {
		this.foto = foto;
	}

	public void setEndereco(EnderecoVO endereco) {
		this.endereco = endereco;
	}

	public void setContato(final ContatoVO contato) {
		this.contato = contato;
	}

	public void setMedicamentos(final Set<MedicamentoVO> medicamentos) {
		this.medicamentos = medicamentos;
	}

	public void setAlergias(Set<AlergiaVO> alergias) {
		this.alergias = alergias;
	}

	public EnderecoVO getEndereco() {
		return endereco;
	}

	public ContatoVO getContato() {
		return contato;
	}

	public Set<MedicamentoVO> getMedicamentos() {
		return medicamentos;
	}

	public Set<AlergiaVO> getAlergias() {
		return alergias;
	}
}