package com.kids.moduloautorizacao;

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
import com.kids.repository.UsuarioRepository;

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
		final UsuarioNovoVO usuarioNovoVO = new UsuarioNovoVO("Luciano Ortiz Silva", "lucianoortizsilva@gmail.com", "51982012911", TipoUsuario.FAMILIAR);
		final Usuario usuario = new Usuario(usuarioNovoVO.getEmail());
		Mockito.when(this.usuarioRepository.findByEmail(Mockito.anyString())).thenReturn(usuario);
		thrown.expect(UsuarioJaCadastradoException.class);
		thrown.expectMessage("O usuário informado já possui cadastro!");
		this.usuarioService.createUsuario(usuarioNovoVO);
	}
}