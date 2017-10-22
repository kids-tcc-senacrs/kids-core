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

}