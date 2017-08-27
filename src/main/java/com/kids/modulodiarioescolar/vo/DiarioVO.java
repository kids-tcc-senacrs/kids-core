package com.kids.modulodiarioescolar.vo;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Representa os objetos da tela de diário escolar
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 08/2017
 *
 */
@ApiModel(description = "diario")
public class DiarioVO implements Serializable {

    private static final long serialVersionUID = 3911814110221110293L;

    @ApiModelProperty
    private Number diarioId;

    @ApiModelProperty
    private Number criancaId;

    @ApiModelProperty
    private String criancaNome;

    @ApiModelProperty
    private String criancaSexo;

    @ApiModelProperty
    private String tipo;

    @ApiModelProperty
    private String nota;

    @ApiModelProperty
    private Date dtLancamento;





    public DiarioVO() {
	super();
    }





    public Number getDiarioId() {
	return diarioId;
    }





    public void setDiarioId(final Number diarioId) {
	this.diarioId = diarioId;
    }





    public Number getCriancaId() {
	return criancaId;
    }





    public void setCriancaId(Number criancaId) {
	this.criancaId = criancaId;
    }





    public String getCriancaNome() {
	return criancaNome;
    }





    public void setCriancaNome(final String criancaNome) {
	this.criancaNome = criancaNome;
    }





    public String getCriancaSexo() {
	return criancaSexo;
    }





    public void setCriancaSexo(final String criancaSexo) {
	this.criancaSexo = criancaSexo;
    }





    public String getTipo() {
	return tipo;
    }





    public void setTipo(final String tipo) {
	this.tipo = tipo;
    }





    public String getNota() {
	return nota;
    }





    public void setNota(final String nota) {
	this.nota = nota;
    }





    public Date getDtLancamento() {
	return dtLancamento;
    }





    public void setDtLancamento(final Date dtLancamento) {
	this.dtLancamento = dtLancamento;
    }

}