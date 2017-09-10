package com.kids.moduloeventos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.moduloeventos.vo.RespostaEventoVO;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 09/2017
 * 
 */
@Service
public class EventoFacade {

    @Autowired
    private EventoService eventoService;





    public List<RespostaEventoVO> getEventosComPresencaConfirmada(final Long usuarioId) {
	return this.eventoService.getRespostasDeEventosConfirmados(usuarioId);
    }

}