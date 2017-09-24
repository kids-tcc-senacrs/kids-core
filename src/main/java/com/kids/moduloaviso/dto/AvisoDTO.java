package com.kids.moduloaviso.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.kids.enumeration.AvisoTipo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 09/2017
 *
 */
@ApiModel(description = "aviso")
public class AvisoDTO implements Serializable {

    private static final long serialVersionUID = -1951783166619495076L;

    @ApiModelProperty(position = 1, required = true)
    private Long crecheId;

    @NotNull(message = "O campo 'descrição' é de preenchimento obrigatório")
    @ApiModelProperty(position = 2, required = true)
    private String descricao;

    @DateTimeFormat(pattern = "yyyy-MM-dd", iso = ISO.DATE, style = "yyyy-MM-dd")
    @ApiModelProperty(position = 3, required = true, notes = "yyyy-MM-dd")
    @NotNull(message = "O campo 'data de expiração' é de preenchimento obrigatório")
    private LocalDate dtExpiracao;

    @ApiModelProperty(position = 4, required = true)
    @NotNull(message = "O campo 'tipo' é de preenchimento obrigatório")
    private AvisoTipo tipo;





    public Long getCrecheId() {
	return crecheId;
    }





    public void setCrecheId(Long crecheId) {
	this.crecheId = crecheId;
    }





    public String getDescricao() {
	return descricao;
    }





    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }





    public LocalDate getDtExpiracao() {
	return dtExpiracao;
    }





    public void setDtExpiracao(LocalDate dtExpiracao) {
	this.dtExpiracao = dtExpiracao;
    }





    public AvisoTipo getTipo() {
	return tipo;
    }





    public void setTipo(AvisoTipo tipo) {
	this.tipo = tipo;
    }

}