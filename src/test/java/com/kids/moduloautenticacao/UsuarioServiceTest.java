package com.kids.moduloautenticacao;

import static org.mockito.Mockito.times;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.kids.enumeration.TipoUsuario;
import com.kids.model.Usuario;
import com.kids.moduloautenticacao.validate.UsuarioInexistenteException;
import com.kids.moduloautenticacao.validate.UsuarioJaCadastradoException;
import com.kids.moduloautenticacao.vo.UsuarioAtualizaVO;
import com.kids.moduloautenticacao.vo.UsuarioNovoVO;
import com.kids.repository.UsuarioRepository;
import com.kids.util.KidsMessageUtil;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 06/2017
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class UsuarioServiceTest {

	@InjectMocks
	private UsuarioService usuarioService;

	@Mock
	private UsuarioRepository usuarioRepository;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void deveGerarUsuarioJaCadastradoException_quandoTentarCadastrarMesmoUsuario() throws Exception {
		final UsuarioNovoVO usuarioNovoVO = new UsuarioNovoVO("Luciano Ortiz Silva", "lucianoortizsilva@gmail.com", TipoUsuario.FAMILIAR);
		final Usuario usuario = new Usuario(usuarioNovoVO.getEmail());
		Mockito.when(this.usuarioRepository.findByEmail(Mockito.anyString())).thenReturn(usuario);
		this.thrown.expect(UsuarioJaCadastradoException.class);
		this.thrown.expectMessage(KidsMessageUtil.getMessage(UsuarioJaCadastradoException.MESSAGE));
		this.usuarioService.saveUsuario(usuarioNovoVO);
	}

	@Test
	public void deveGerarUsuarioInexistenteException_quandoTentarAtualizarUsuarioInexistente() throws Exception {
		Mockito.when(this.usuarioRepository.findUsuarioById(Mockito.anyLong())).thenReturn(null);
		this.thrown.expect(UsuarioInexistenteException.class);
		this.thrown.expectMessage(KidsMessageUtil.getMessage(UsuarioInexistenteException.MESSAGE));
		this.usuarioService.updateUsuario(new UsuarioAtualizaVO());
	}

	@Test
	public void deveSalvarUsuarioComSucesso() throws Exception {
		final UsuarioNovoVO usuarioNovoVO = new UsuarioNovoVO("Luciano Ortiz Silva", "lucianoortizsilva@gmail.com", TipoUsuario.FAMILIAR);
		this.usuarioService.saveUsuario(usuarioNovoVO);
		Mockito.verify(usuarioRepository, times(1)).persist(Mockito.any(Usuario.class));
	}

}