package com.kids.moduloeventos.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kids.enumeration.EventoStatus;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Representa os objetos da tela de eventos
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 09/2017
 *
 */
@ApiModel(description = "evento")
public class EventoDTO implements Serializable {

	private static final long serialVersionUID = -1951783166619495076L;

	@ApiModelProperty(position = 0)
	private Long eventoId;

	@NotNull(message = "o campo 'id da creche' é de preenchimento obrigatório")
	@ApiModelProperty(position = 1, required = true)
	private Long crecheId;

	@NotEmpty(message = "o campo 'nome' é de preenchimento obrigatório")
	@ApiModelProperty(position = 2, required = true)
	private String eventoNome;

	@NotEmpty(message = "o campo 'descrição' é de preenchimento obrigatório")
	@ApiModelProperty(position = 3, required = true)
	private String descricao;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd HH:mm")
	@NotNull(message = "o campo 'Data de realização' é de preenchimento obrigatório")
	@ApiModelProperty(position = 4, required = true)
	private String dtRealizacao;

	@ApiModelProperty(position = 5)
	private EventoStatus status;

	public EventoDTO(Long eventoId, Long crecheId, String eventoNome, String descricao, String dtRealizacao, EventoStatus status) {
		super();
		this.eventoId = eventoId;
		this.crecheId = crecheId;
		this.eventoNome = eventoNome;
		this.descricao = descricao;
		this.dtRealizacao = dtRealizacao;
		this.status = status;
	}

	public EventoDTO() {
		super();
	}

	public Long getEventoId() {
		return eventoId;
	}

	public void setEventoId(Long eventoId) {
		this.eventoId = eventoId;
	}

	public Long getCrecheId() {
		return crecheId;
	}

	public void setCrecheId(Long crecheId) {
		this.crecheId = crecheId;
	}

	public String getEventoNome() {
		return eventoNome;
	}

	public void setEventoNome(String eventoNome) {
		this.eventoNome = eventoNome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDtRealizacao() {
		return dtRealizacao;
	}

	public void setDtRealizacao(String dtRealizacao) {
		this.dtRealizacao = dtRealizacao;
	}

	public EventoStatus getStatus() {
		return status;
	}

	public void setStatus(EventoStatus status) {
		this.status = status;
	}

}