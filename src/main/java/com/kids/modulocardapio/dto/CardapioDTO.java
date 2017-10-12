package com.kids.modulocardapio.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 10/2017
 *
 */
@ApiModel(description = "cardapio")
public class CardapioDTO implements Serializable {

    private static final long serialVersionUID = 8111638718831726633L;

    @NotNull(message = "O campo 'crecheId' é de preenchimento obrigatório")
    @ApiModelProperty(position = 0, required = true)
    private Number crecheId;

    @DateTimeFormat(pattern = "yyyy-MM-dd", iso = ISO.DATE, style = "yyyy-MM-dd")
    @ApiModelProperty(position = 1, required = true, notes = "yyyy-MM-dd")
    @NotNull(message = "O campo 'data do cardápio' é de preenchimento obrigatório")
    private LocalDate dtCardapio;

    @NotNull(message = "O campo 'alimento' é de preenchimento obrigatório")
    @ApiModelProperty(position = 2)
    private String alimento;





    public CardapioDTO() {
	super();
    }





    public Number getCrecheId() {
	return crecheId;
    }





    public void setCrecheId(Number crecheId) {
	this.crecheId = crecheId;
    }





    public LocalDate getDtCardapio() {
	return dtCardapio;
    }





    public void setDtCardapio(LocalDate dtCardapio) {
	this.dtCardapio = dtCardapio;
    }





    public String getAlimento() {
	return alimento;
    }





    public void setAlimento(String alimento) {
	this.alimento = alimento;
    }

}