package com.kids.moduloaviso;

import static org.mockito.Mockito.times;

import java.time.LocalDate;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.kids.enumeration.AvisoTipo;
import com.kids.model.Aviso;
import com.kids.moduloaviso.dto.AvisoDTO;
import com.kids.modulocreche.CrecheFacade;
import com.kids.repository.AvisoRepository;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 09/2017
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AvisoServiceTest {

	@InjectMocks
	private AvisoService avisoService;

	@Mock
	private AvisoRepository avisoRepository;

	@Mock
	private CrecheFacade crecheFacade;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void deveSalvarAvisoComSucesso() throws Exception {
		final LocalDate dtExpiracao = LocalDate.of(2020, 1, 31);
		final AvisoDTO avisoDTO = new AvisoDTO(Long.valueOf(1), "", dtExpiracao, AvisoTipo.INFORMACAO);
		this.avisoService.save(avisoDTO);
		Mockito.verify(this.avisoRepository, times(1)).persist(Mockito.any(Aviso.class));
	}
}