package com.kids.modulocrianca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.kids.modulocreche.CrecheFacade;
import com.kids.modulocrianca.vo.CriancaNovoVO;
import com.kids.repository.CriancaRepository;
import com.kids.util.MessageUtil;

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
    public void deveGerarCrecheInexistenteException_quandoTentarCadastrarCriancaComCrecheInexistente() throws Exception {
	Mockito.when(this.crecheFacade.get(Mockito.anyLong())).thenReturn(null);
	this.thrown.expect(CrecheInexistenteException.class);
	this.thrown.expectMessage(MessageUtil.getMessage("message_crecheInexistenteException"));
	this.criancaService.save(new CriancaNovoVO());
    }

}