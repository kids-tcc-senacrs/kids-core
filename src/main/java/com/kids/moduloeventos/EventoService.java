package com.kids.moduloeventos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.exception.KidsException;
import com.kids.moduloautenticacao.UsuarioFacade;
import com.kids.moduloeventos.validate.ValidateEvento;
import com.kids.moduloeventos.vo.EventoVO;
import com.kids.repository.EventoRepository;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private UsuarioFacade usuarioFacade;





    public List<EventoVO> getEventosByUsuarioFamiliar(final Long usuarioId) throws KidsException {
	final ValidateEvento validate = new ValidateEvento(usuarioFacade);
	validate.validar(usuarioId);
	return this.eventoRepository.findEventos(usuarioId);
    }

}