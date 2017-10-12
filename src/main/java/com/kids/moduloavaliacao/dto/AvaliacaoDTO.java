package com.kids.moduloavaliacao.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 10/2017
 *
 */
@ApiModel(description = "avaliacao")
public class AvaliacaoDTO implements Serializable {

    private static final long serialVersionUID = -3767386615200793307L;

    @NotNull(message = "O campo 'crecheId' é de preenchimento obrigatório")
    @ApiModelProperty(position = 0, required = true)
    private Number crecheId;

    @NotNull(message = "O campo 'criancaId' é de preenchimento obrigatório")
    @ApiModelProperty(position = 1, required = true)
    private Number criancaId;

    @NotNull(message = "O campo 'descrição' é de preenchimento obrigatório")
    @ApiModelProperty(position = 2, required = true)
    private String descricao;





    public Number getCrecheId() {
	return crecheId;
    }





    public void setCrecheId(final Number crecheId) {
	this.crecheId = crecheId;
    }





    public Number getCriancaId() {
	return criancaId;
    }





    public void setCriancaId(final Number criancaId) {
	this.criancaId = criancaId;
    }





    public String getDescricao() {
	return descricao;
    }





    public void setDescricao(final String descricao) {
	this.descricao = descricao;
    }

}