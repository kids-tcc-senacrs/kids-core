package com.kids.modulocrianca;

import static org.mockito.Mockito.times;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.kids.exception.KidsException;
import com.kids.model.Creche;
import com.kids.model.Crianca;
import com.kids.modulocreche.CrecheFacade;
import com.kids.modulocrianca.validate.CrecheInexistenteException;
import com.kids.modulocrianca.validate.CriancaInexistenteException;
import com.kids.modulocrianca.validate.CriancaJaCadastradaException;
import com.kids.modulocrianca.vo.CriancaAtualizaVO;
import com.kids.modulocrianca.vo.CriancaNovoVO;
import com.kids.repository.CriancaRepository;
import com.kids.util.KidsMessageUtil;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CriancaServiceTest {

	@InjectMocks
	private CriancaService criancaService;

	@Mock
	private CriancaRepository criancaRepository;

	@Mock
	private CrecheFacade crecheFacade;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void deveGerarCrecheInexistenteException_quandoTentarCadastrarCriancaInformandoCrecheInexistente() throws KidsException {
		Mockito.when(this.crecheFacade.getCreche(Mockito.anyLong())).thenReturn(null);
		this.thrown.expect(CrecheInexistenteException.class);
		this.thrown.expectMessage(KidsMessageUtil.getMessage(CrecheInexistenteException.MESSAGE));
		this.criancaService.save(new CriancaNovoVO());
	}

	@Test
	public void deveGerarCriancaInexistenteException_quandoTentarAtualizarDadosDeAlgumaCriancaNaoCadastrada() throws KidsException {
		Mockito.when(this.criancaRepository.findCrianca(Mockito.anyLong())).thenReturn(null);
		this.thrown.expect(CriancaInexistenteException.class);
		this.thrown.expectMessage(KidsMessageUtil.getMessage(CriancaInexistenteException.MESSAGE));
		this.criancaService.update(new CriancaAtualizaVO());
	}

	@Test
	public void deveGerarCriancaJaCadastradaException_quandoTentarCadastrarUmMesmaCriancaJaCadastradaNaDevidaCreche() throws KidsException {
		Mockito.when(this.crecheFacade.getCreche(Mockito.anyLong())).thenReturn(new Creche());
		Mockito.when(this.criancaRepository.findCriancasByCrecheAndMatricula(Mockito.any(), Mockito.anyString())).thenReturn(new Crianca());
		this.thrown.expect(CriancaJaCadastradaException.class);
		this.thrown.expectMessage(KidsMessageUtil.getMessage(CriancaJaCadastradaException.MESSAGE));
		this.criancaService.save(new CriancaNovoVO());
	}

	@Test
	public void deveCadastrarCriancaComSucesso() throws KidsException {
		Mockito.when(this.crecheFacade.getCreche(Mockito.anyLong())).thenReturn(new Creche());
		Mockito.when(this.criancaRepository.findCriancasByCrecheAndMatricula(Mockito.any(), Mockito.anyString())).thenReturn(null);
		this.criancaService.save(new CriancaNovoVO());
		Mockito.verify(this.criancaRepository, times(1)).persist(Mockito.any(Crianca.class));
	}

	@Test
	public void deveAtualizarCriancaComSucesso() throws KidsException {
		Mockito.when(this.crecheFacade.getCreche(Mockito.anyLong())).thenReturn(new Creche());
		Mockito.when(this.criancaRepository.findCriancasByCrecheAndMatricula(Mockito.any(), Mockito.anyString())).thenReturn(null);
		Mockito.when(this.criancaRepository.findCrianca(Mockito.anyLong())).thenReturn(new Crianca());
		this.criancaService.update(new CriancaAtualizaVO());
		Mockito.verify(this.criancaRepository, times(1)).update(Mockito.any(Crianca.class));
	}

}