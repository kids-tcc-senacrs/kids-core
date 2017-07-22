package com.kids.modulocrianca.vo;

import java.io.Serializable;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 * 
 */
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





    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((nome == null) ? 0 : nome.hashCode());
	return result;
    }





    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	MedicamentoVO other = (MedicamentoVO) obj;
	if (nome == null) {
	    if (other.nome != null)
		return false;
	} else if (!nome.equals(other.nome))
	    return false;
	return true;
    }
}
