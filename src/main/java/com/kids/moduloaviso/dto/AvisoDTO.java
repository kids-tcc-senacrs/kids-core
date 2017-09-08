package com.kids.moduloaviso.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import com.kids.enumeration.AvisoOrigem;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Representa os objetos da tela de eventos
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 09/2017
 *
 */
@ApiModel(description = "aviso")
public class AvisoDTO implements Serializable {

    private static final long serialVersionUID = -1951783166619495076L;

    @ApiModelProperty(position = 2, required = true)
    private Long crecheId;

    @NotNull(message = "O campo 'descrição' é de preenchimento obrigatório")
    @ApiModelProperty(position = 3, required = true)
    private String descricao;

    @NotNull(message = "O campo 'data de expiração' é de preenchimento obrigatório")
    @ApiModelProperty(position = 4, required = true)
    private Date dtExpiracao;

    @Enumerated(EnumType.STRING)
    @ApiModelProperty(position = 5, required = true)
    @NotNull(message = "O campo 'origem' é de preenchimento obrigatório")
    private AvisoOrigem origem;





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





    public Date getDtExpiracao() {
	return dtExpiracao;
    }





    public void setDtExpiracao(Date dtExpiracao) {
	this.dtExpiracao = dtExpiracao;
    }





    public AvisoOrigem getOrigem() {
	return origem;
    }





    public void setOrigem(AvisoOrigem origem) {
	this.origem = origem;
    }

}