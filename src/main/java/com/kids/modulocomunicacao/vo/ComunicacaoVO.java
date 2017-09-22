package com.kids.modulocomunicacao.vo;

import java.io.Serializable;
import java.util.Date;

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

    @ApiModelProperty(position = 4, notes = "ELOGIO, RECLAMACAO ou SUGESTAO")
    private String tipo;

    @ApiModelProperty(position = 5)
    private Boolean crecheRespondeu;

    @ApiModelProperty(position = 6)
    private Date dtEnvioFamiliar;

    @ApiModelProperty(position = 7)
    private Date dtRespostaCreche;





    public Number getComunicacaoId() {
	return comunicacaoId;
    }





    public void setComunicacaoId(Number comunicacaoId) {
	this.comunicacaoId = comunicacaoId;
    }





    public String getUsuarioNome() {
	return usuarioNome;
    }





    public void setUsuarioNome(String usuarioNome) {
	this.usuarioNome = usuarioNome;
    }





    public String getDescricaoFamiliar() {
	return descricaoFamiliar;
    }





    public void setDescricaoFamiliar(String descricaoFamiliar) {
	this.descricaoFamiliar = descricaoFamiliar;
    }





    public String getDescricaoCreche() {
	return descricaoCreche;
    }





    public void setDescricaoCreche(String descricaoCreche) {
	this.descricaoCreche = descricaoCreche;
    }





    public String getTipo() {
	return tipo;
    }





    public void setTipo(String tipo) {
	this.tipo = tipo;
    }





    public Boolean getCrecheRespondeu() {
	return crecheRespondeu;
    }





    public void setCrecheRespondeu(Boolean crecheRespondeu) {
	this.crecheRespondeu = crecheRespondeu;
    }





    public Date getDtEnvioFamiliar() {
	return dtEnvioFamiliar;
    }





    public void setDtEnvioFamiliar(Date dtEnvioFamiliar) {
	this.dtEnvioFamiliar = dtEnvioFamiliar;
    }





    public Date getDtRespostaCreche() {
	return dtRespostaCreche;
    }





    public void setDtRespostaCreche(Date dtRespostaCreche) {
	this.dtRespostaCreche = dtRespostaCreche;
    }

}