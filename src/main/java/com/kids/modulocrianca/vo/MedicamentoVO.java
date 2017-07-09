package com.kids.modulocrianca.vo;

import java.io.Serializable;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "medicamento")
public class MedicamentoVO implements Serializable {

	private static final long serialVersionUID = -7841487636157526050L;

	@ApiModelProperty(position = 0)
	@Size(max = 8, message = "o campo 'nome' deve conter '40' caracteres")
	private String nome;

	@ApiModelProperty(position = 1)
	@Size(max = 25, message = "o campo 'dosagem' deve conter '25' caracteres")
	private String dosagem;

	@ApiModelProperty(position = 2)
	@Size(max = 10, message = "o campo 'intervalo Horas' deve conter '10' caracteres")
	private String intervaloHoras;

	@ApiModelProperty(position = 3, notes = "yyyy-MM-dd")
	private String dtFinal;



	public MedicamentoVO() {
		super();
	}



	public String getNome() {
		return nome;
	}



	public String getDosagem() {
		return dosagem;
	}



	public String getIntervaloHoras() {
		return intervaloHoras;
	}



	public String getDtFinal() {
		return dtFinal;
	}
}
