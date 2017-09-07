package com.kids.moduloeventos.validate;

import java.util.Objects;

import com.kids.enumeration.TipoUsuario;
import com.kids.model.Usuario;
import com.kids.moduloautenticacao.UsuarioFacade;
import com.kids.repository.EventoRepository;

public class ValidateEvento {

    private EventoRepository eventoRepository;

    private UsuarioFacade usuarioFacade;





    public ValidateEvento(final EventoRepository eventoRepository) {
	this.eventoRepository = eventoRepository;
	Objects.requireNonNull(this.eventoRepository, "deve informar uma instancia de EventoRepository");
    }





    public ValidateEvento(final UsuarioFacade usuarioFacade) {
	this.usuarioFacade = usuarioFacade;
	Objects.requireNonNull(this.usuarioFacade, "deve informar uma instancia de UsuarioFacade");
    }





    public void validar(final Long usuarioId) throws UsuarioInexistenteException, TipoUsuarioInvalidoException {
	final Usuario usuario = this.usuarioFacade.getUsuarioById(usuarioId);
	if (usuario == null) {
	    throw new UsuarioInexistenteException();
	} else if (!TipoUsuario.FAMILIAR.equals(usuario.getTipo())) {
	    throw new TipoUsuarioInvalidoException();
	}
    }

}