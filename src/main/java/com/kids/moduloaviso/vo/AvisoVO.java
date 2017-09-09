package com.kids.moduloaviso.vo;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Representa os objetos da tela de aviso
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 09/2017
 *
 */
@ApiModel(description = "aviso")
public class AvisoVO implements Serializable {

    private static final long serialVersionUID = -1951783166619495076L;

    @ApiModelProperty(position = 0)
    private Number avisoId;

    @ApiModelProperty(position = 1)
    private String crecheNome;

    @ApiModelProperty(position = 2)
    private String descricao;

    @ApiModelProperty(position = 3)
    private String tipo;

    @ApiModelProperty(position = 4)
    private Date dtExpiracao;





    public Number getAvisoId() {
	return avisoId;
    }





    public void setAvisoId(Number avisoId) {
	this.avisoId = avisoId;
    }





    public String getCrecheNome() {
	return crecheNome;
    }





    public void setCrecheNome(String crecheNome) {
	this.crecheNome = crecheNome;
    }





    public String getDescricao() {
	return descricao;
    }





    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }





    public String getTipo() {
	return tipo;
    }





    public void setTipo(String tipo) {
	this.tipo = tipo;
    }





    public Date getDtExpiracao() {
	return dtExpiracao;
    }





    public void setDtExpiracao(Date dtExpiracao) {
	this.dtExpiracao = dtExpiracao;
    }

}