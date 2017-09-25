package com.kids.moduloeventos;

import static org.mockito.Mockito.times;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.kids.enumeration.EventoStatus;
import com.kids.model.Evento;
import com.kids.modulocreche.CrecheFacade;
import com.kids.moduloeventos.dto.EventoDTO;
import com.kids.repository.EventoRepository;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 09/2017
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class EventoServiceTest {

	@InjectMocks
	private EventoService eventoService;

	@Mock
	private EventoRepository eventoRepository;

	@Mock
	private CrecheFacade crecheFacade;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	@Ignore
	public void deveSalvarEventoComSucesso() throws Exception {
		final EventoDTO eventoDTO = new EventoDTO(Long.valueOf(1), Long.valueOf(1), "evento nome", "descricao evento", "2020013108:00.000", EventoStatus.PREVISTO);
		this.eventoService.save(eventoDTO);
		Mockito.verify(this.eventoRepository, times(1)).save(Mockito.any(Evento.class));
	}
	
}