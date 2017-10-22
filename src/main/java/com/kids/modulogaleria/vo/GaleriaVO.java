package com.kids.modulogaleria.vo;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Representa os objetos da tela de galerias
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 10/2017
 *
 */
@ApiModel(description = "galeria")
public class GaleriaVO implements Serializable {

    private static final long serialVersionUID = -1951783166619495076L;

    @ApiModelProperty(position = 0)
    private Number id;

    @ApiModelProperty(position = 1)
    private String descricao;

    @ApiModelProperty(position = 2)
    private String imagem;

    @ApiModelProperty(position = 8)
    private Date dtPost;





    public Number getId() {
	return id;
    }





    public void setId(Number id) {
	this.id = id;
    }





    public String getDescricao() {
	return descricao;
    }





    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }





    public String getImagem() {
	return imagem;
    }





    public void setImagem(String imagem) {
	this.imagem = imagem;
    }





    public Date getDtPost() {
	return dtPost;
    }





    public void setDtPost(Date dtPost) {
	this.dtPost = dtPost;
    }





    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
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
	GaleriaVO other = (GaleriaVO) obj;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	return true;
    }

}