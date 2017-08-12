package com.kids.modulocrianca.vo;

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
public class AlergiaVO {

    @ApiModelProperty(position = 0, required = true)
    @Size(max = 50, message = "o campo 'descricao' deve conter no máximo '50' caracteres")
    private String descricao;

    private Long id;





    public AlergiaVO(final String descricao) {
	this.descricao = descricao;
    }





    public Long getId() {
	return id;
    }





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