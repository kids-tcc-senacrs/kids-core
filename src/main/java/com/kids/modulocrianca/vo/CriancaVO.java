package com.kids.modulocrianca.vo;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

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

	@Valid
	@ApiModelProperty(position = 0, required = true)
	private CrecheVo creche;

	@Valid
	@ApiModelProperty(position = 1, required = true)
	private GeralVO geral;

	@Valid
	@ApiModelProperty(position = 2, required = true)
	private EnderecoVO endereco;

	@Valid
	@ApiModelProperty(position = 3, required = true)
	private ContatoVO contato;

	@Valid
	@ApiModelProperty(position = 4)
	private List<MedicamentoVO> medicamentos;

	@Valid
	@ApiModelProperty(position = 5)
	private List<AlergiaVO> alergias;



	public CriancaVO() {
		super();
	}



	public GeralVO getGeral() {
		return geral;
	}



	public EnderecoVO getEndereco() {
		return endereco;
	}



	public ContatoVO getContato() {
		return contato;
	}



	public List<MedicamentoVO> getMedicamentos() {
		return medicamentos;
	}



	public List<AlergiaVO> getAlergias() {
		return alergias;
	}



	public CrecheVo getCreche() {
		return creche;
	}
}