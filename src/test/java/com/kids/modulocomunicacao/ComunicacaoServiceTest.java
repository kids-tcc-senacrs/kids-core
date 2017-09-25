package com.kids.modulocomunicacao;

import static org.mockito.Mockito.times;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.kids.enumeration.ComunicacaoTipo;
import com.kids.enumeration.TipoUsuario;
import com.kids.model.Comunicacao;
import com.kids.model.Usuario;
import com.kids.moduloautenticacao.UsuarioFacade;
import com.kids.modulocomunicacao.dto.ComunicacaoDTO;
import com.kids.modulocreche.CrecheFacade;
import com.kids.repository.ComunicacaoRepository;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 09/2017
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ComunicacaoServiceTest {

	@InjectMocks
	private ComunicacaoService comunicacaoService;

	@Mock
	private ComunicacaoRepository comunicacaoRepository;

	@Mock
	private CrecheFacade crecheFacade;

	@Mock
	private UsuarioFacade usuarioFacade;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void deveSalvarComunicacaoComSucesso() throws Exception {
		final ComunicacaoDTO comunicacaoDTO = new ComunicacaoDTO(Long.valueOf(1), Long.valueOf(1), Long.valueOf(1), ComunicacaoTipo.ELOGIO, "", "");
		final Usuario usuario = new Usuario(TipoUsuario.FAMILIAR);
		Mockito.when(this.usuarioFacade.getUsuarioById(Mockito.anyLong())).thenReturn(usuario);
		this.comunicacaoService.save(comunicacaoDTO);
		Mockito.verify(this.comunicacaoRepository, times(1)).persist(Mockito.any(Comunicacao.class));
	}

}