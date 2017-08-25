package com.kids.modulodiarioescolar.dto;

import java.io.Serializable;

import com.kids.enumeration.DiarioNota;
import com.kids.enumeration.DiarioTipo;

import io.swagger.annotations.ApiModel;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 08/2017
 * 
 */
@ApiModel(description = "diario")
public class DiarioDTO implements Serializable {

    private static final long serialVersionUID = 8195544286218444392L;

    private Long crecheId;

    private Long criancaId;

    private DiarioTipo tipo;

    private DiarioNota nota;





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