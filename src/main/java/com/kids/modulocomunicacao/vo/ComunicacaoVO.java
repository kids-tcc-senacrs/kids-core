package com.kids.modulocomunicacao.vo;

import java.io.Serializable;
import java.util.Date;

import com.kids.enumeration.ComunicacaoTipo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Representa os objetos da tela de comunicacao
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 09/2017
 *
 */
@ApiModel(description = "comunicado")
public class ComunicacaoVO implements Serializable {

    private static final long serialVersionUID = 3911814110221110293L;

    @ApiModelProperty(position = 0)
    private Number comunicacaoId;

    @ApiModelProperty(position = 1)
    private String usuarioNome;

    @ApiModelProperty(position = 2)
    private String descricaoFamiliar;

    @ApiModelProperty(position = 3)
    private String descricaoCreche;

    @ApiModelProperty(position = 4)
    private ComunicacaoTipo tipo;

    @ApiModelProperty(position = 5)
    private Boolean crecheRespondeu;

    @ApiModelProperty(position = 6)
    private Date dtEnvioFamiliar;

    @ApiModelProperty(position = 7)
    private Date dtRespostaCreche;

}