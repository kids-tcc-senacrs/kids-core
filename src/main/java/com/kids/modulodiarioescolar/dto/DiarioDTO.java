package com.kids.modulodiarioescolar.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.kids.enumeration.DiarioNota;
import com.kids.enumeration.DiarioTipo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 08/2017
 * 
 */
@ApiModel(description = "diarioDTO")
public class DiarioDTO implements Serializable {

    private static final long serialVersionUID = 8195544286218444392L;

    @ApiModelProperty(position = 0)
    private Long id;

    @ApiModelProperty(position = 1, required = true)
    private Long crecheId;

    @ApiModelProperty(position = 2, required = true)
    private Long criancaId;

    @ApiModelProperty(position = 3, required = true)
    @NotNull(message = "o campo 'tipo' é de preenchimento obrigatório")
    private DiarioTipo tipo;

    @ApiModelProperty(position = 4, required = true)
    @NotNull(message = "o campo 'nota' é de preenchimento obrigatório")
    private DiarioNota nota;





    public Long getId() {
	return id;
    }





    public Long getCrecheId() {
	return crecheId;
    }





    public void setCrecheId(final Long crecheId) {
	this.crecheId = crecheId;
    }





    public Long getCriancaId() {
	return criancaId;
    }





    public void setCriancaId(final Long criancaId) {
	this.criancaId = criancaId;
    }





    public DiarioTipo getTipo() {
	return tipo;
    }





    public void setTipo(final DiarioTipo tipo) {
	this.tipo = tipo;
    }





    public DiarioNota getNota() {
	return nota;
    }





    public void setNota(final DiarioNota nota) {
	this.nota = nota;
    }

}