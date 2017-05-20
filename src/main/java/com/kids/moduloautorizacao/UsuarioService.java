package com.kids.moduloautorizacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.model.Pessoa;
import com.kids.model.Usuario;
import com.kids.repository.PessoaRepository;
import com.kids.repository.UsuarioRepository;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 05/2017
 * 
 */
@Service
public class UsuarioService {

	private PessoaRepository pessoaRepository;
	private UsuarioRepository usuarioRepository;

	@Autowired
	public UsuarioService(final PessoaRepository pessoaRepository, final UsuarioRepository usuarioRepository) {
		super();
		this.pessoaRepository = pessoaRepository;
		this.usuarioRepository = usuarioRepository;
	}

	public Pessoa createPessoa(final Pessoa pessoa) {
		return this.pessoaRepository.save(pessoa);
	}

	public Usuario createUsuario(final Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}

}