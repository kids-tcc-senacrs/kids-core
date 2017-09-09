package com.kids.moduloeventos.build;

import java.util.Objects;

import com.kids.enumeration.EventoStatus;
import com.kids.model.Evento;
import com.kids.modulocreche.CrecheFacade;
import com.kids.moduloeventos.dto.EventoDTO;
import com.kids.repository.EventoRepository;
import com.kids.util.KidsDateUtil;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 09/2017
 *
 */
public class BuildEvento {

    private Evento evento = new Evento();

    private CrecheFacade crecheFacade;

    private EventoRepository eventoRepository;





    public BuildEvento() {
	super();
    }





    public BuildEvento(final CrecheFacade crecheFacade) {
	this.crecheFacade = crecheFacade;
	Objects.requireNonNull(this.crecheFacade, "deve informar uma instancia de crecheFacade");
    }





    public BuildEvento(final EventoRepository eventoRepository) {
	this.eventoRepository = eventoRepository;
	Objects.requireNonNull(this.eventoRepository, "deve informar uma instancia de EventoRepository");
    }





    public void update(final EventoDTO dto) {
	this.evento = this.eventoRepository.findEvento(dto.getEventoId());
	this.evento.setStatus(dto.getStatus());
    }





    public void create(final EventoDTO dto) {
	this.evento.setCreche(this.crecheFacade.getCreche(dto.getCrecheId().longValue()));
	this.evento.setDescricao(dto.getDescricao());
	this.evento.setNome(dto.getEventoNome());
	this.evento.setStatus(EventoStatus.PREVISTO);
	this.evento.setDtRealizacao(KidsDateUtil.converterZoneDatetimeToLocalDateTime(dto.getDtRealizacao()));
    }





    public Evento getEvento() {
	return evento;
    }
}