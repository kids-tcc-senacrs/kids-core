package com.kids.moduloeventos.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.kids.enumeration.EventoRespostaStatus;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * *
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 09/2017
 *
 */
@ApiModel(description = "resposta_evento")
public class RespostaEventoDTO implements Serializable {

    private static final long serialVersionUID = -1951783166619495076L;

    @NotNull(message = "o campo 'id do evento' é de preenchimento obrigatório")
    @ApiModelProperty(position = 0)
    private Long eventoId;

    @NotNull(message = "o campo 'id da crianca' é de preenchimento obrigatório")
    @ApiModelProperty(position = 1, required = true)
    private Long criancaId;

    @NotNull(message = "o campo 'id do usuario' é de preenchimento obrigatório")
    @ApiModelProperty(position = 2, required = true)
    private Long usuarioId;

    @NotNull(message = "o campo 'status' é de preenchimento obrigatório")
    @ApiModelProperty(position = 3, required = true)
    private EventoRespostaStatus eventoRespostaStatus;





    public Long getEventoId() {
	return eventoId;
    }





    public void setEventoId(Long eventoId) {
	this.eventoId = eventoId;
    }





    public Long getCriancaId() {
	return criancaId;
    }





    public void setCriancaId(Long criancaId) {
	this.criancaId = criancaId;
    }





    public Long getUsuarioId() {
	return usuarioId;
    }





    public void setUsuarioId(Long usuarioId) {
	this.usuarioId = usuarioId;
    }





    public EventoRespostaStatus getEventoRespostaStatus() {
	return eventoRespostaStatus;
    }





    public void setEventoRespostaStatus(EventoRespostaStatus eventoRespostaStatus) {
	this.eventoRespostaStatus = eventoRespostaStatus;
    }

}