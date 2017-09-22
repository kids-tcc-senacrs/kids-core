package com.kids.modulocomunicacao.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.kids.enumeration.ComunicacaoTipo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 09/2017
 * 
 */
@ApiModel(description = "comunicacaoDTO")
public class ComunicacaoDTO implements Serializable {

    private static final long serialVersionUID = 5297714208132822588L;

    @ApiModelProperty(position = 0, required = false)
    private Long id;

    @NotNull(message = "o campo 'id da creche' é de preenchimento obrigatório")
    @ApiModelProperty(position = 1, required = true)
    private Long crecheId;

    @NotNull(message = "o campo 'id do usuario familiar' é de preenchimento obrigatório")
    @ApiModelProperty(position = 2, required = true)
    private Long usuarioId;

    @ApiModelProperty(position = 3, required = true)
    @NotNull(message = "o campo 'tipo' é de preenchimento obrigatório")
    private ComunicacaoTipo tipo;

    @NotNull(message = "o campo 'descrição do familiar' é de preenchimento obrigatório")
    @ApiModelProperty(position = 4, required = true)
    private String descricaoFamiliar;

    @ApiModelProperty(position = 5, required = false)
    private String descricaoCreche;

    @NotNull(message = "o campo 'resposta da creche' é de preenchimento obrigatório")
    @ApiModelProperty(position = 6, required = true)
    private Boolean respostaDaCreche;





    public Long getId() {
	return id;
    }





    public Long getCrecheId() {
	return crecheId;
    }





    public Long getUsuarioId() {
	return usuarioId;
    }





    public ComunicacaoTipo getTipo() {
	return tipo;
    }





    public String getDescricaoFamiliar() {
	return descricaoFamiliar;
    }





    public String getDescricaoCreche() {
	return descricaoCreche;
    }





    public Boolean getRespostaDaCreche() {
	return respostaDaCreche;
    }

}