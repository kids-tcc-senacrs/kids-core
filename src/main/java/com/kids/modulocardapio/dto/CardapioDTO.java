package com.kids.modulocardapio.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
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
    private Long crecheId;

    @DateTimeFormat(pattern = "yyyy-MM-dd", iso = ISO.DATE, style = "yyyy-MM-dd")
    @ApiModelProperty(position = 1, required = true, notes = "yyyy-MM-dd")
    @NotNull(message = "O campo 'data do cardápio' é de preenchimento obrigatório")
    private LocalDate dtCardapio;

    @Valid
    @ApiModelProperty(position = 2)
    private List<AlimentoDTO> alimentos;





    public CardapioDTO() {
	super();
    }





    public Long getCrecheId() {
	return crecheId;
    }





    public void setCrecheId(Long crecheId) {
	this.crecheId = crecheId;
    }





    public LocalDate getDtCardapio() {
	return dtCardapio;
    }





    public void setDtCardapio(LocalDate dtCardapio) {
	this.dtCardapio = dtCardapio;
    }





    public List<AlimentoDTO> getAlimentos() {
	return alimentos;
    }





    public void setAlimentos(List<AlimentoDTO> alimentos) {
	this.alimentos = alimentos;
    }

}