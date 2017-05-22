package com.kids.moduloautorizacao;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.kids.model.Usuario;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 05/2017
 * 
 */
public class UsuarioVO implements Serializable {

	private static final long serialVersionUID = -4250740341959384029L;

	@Size(max = 60, message = "o campo 'nome' deve conter no máximo '60' caracteres")
	@NotNull(message = "o campo 'nome' é de preenchimento obrigatório")
	@NotEmpty(message = "o campo 'nome' é de preenchimento obrigatório")
	private String nome;

	@Size(max = 30, message = "o campo 'apelido' deve conter no máximo '30' caracteres")
	private String apelido;

	@Email(message = "o 'email' informado não é um endereço de email valido")
	@Size(max = 120, message = "o campo 'email' deve conter no máximo '120' caracteres")
	@NotNull(message = "o campo 'email' é de preenchimento obrigatório")
	@NotEmpty(message = "o campo 'email' é de preenchimento obrigatório")
	private String email;

	@Size(max = 20, message = "o campo 'telefone' deve conter no máximo '20' caracteres")
	private String telefone;

	@Size(max = 300, message = "o campo 'fotoUrl' deve conter no máximo '300' caracteres")
	private String fotoUrl;

	@NotNull(message = "o campo 'tipo' é de preenchimento obrigatório")
	private Usuario.Tipo tipo;

	public String getNome() {
		return nome;
	}

	public String getApelido() {
		return apelido;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getFotoUrl() {
		return fotoUrl;
	}

	public Usuario.Tipo getTipo() {
		return tipo;
	}

}