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
@ApiModel(description = "alergia")
public class AlergiaVO implements Serializable {

    private static final long serialVersionUID = -5088394951428811478L;

    @ApiModelProperty(position = 0, required = true)
    @Size(max = 60, message = "o campo 'descricao' deve conter no máximo '60' caracteres")
    private String descricao;





    public AlergiaVO() {
	super();
    }





    public String getDescricao() {
	return descricao;
    }





    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
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
	AlergiaVO other = (AlergiaVO) obj;
	if (descricao == null) {
	    if (other.descricao != null)
		return false;
	} else if (!descricao.equals(other.descricao))
	    return false;
	return true;
    }
}