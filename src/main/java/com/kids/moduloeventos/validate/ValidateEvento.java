package com.kids.moduloeventos.validate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.kids.enumeration.TipoUsuario;
import com.kids.exception.KidsException;
import com.kids.model.Usuario;
import com.kids.moduloautenticacao.UsuarioFacade;
import com.kids.modulocreche.CrecheFacade;
import com.kids.modulocrianca.validate.CrecheInexistenteException;
import com.kids.moduloeventos.dto.EventoDTO;
import com.kids.repository.EventoRepository;

public class ValidateEvento {

    private EventoRepository eventoRepository;

    private UsuarioFacade usuarioFacade;

    private CrecheFacade crecheFacade;





    public ValidateEvento(final EventoRepository eventoRepository) {
	this.eventoRepository = eventoRepository;
	Objects.requireNonNull(this.eventoRepository, "deve informar uma instancia de EventoRepository");
    }





    public ValidateEvento(final UsuarioFacade usuarioFacade) {
	this.usuarioFacade = usuarioFacade;
	Objects.requireNonNull(this.usuarioFacade, "deve informar uma instancia de UsuarioFacade");
    }





    public ValidateEvento(final CrecheFacade crecheFacade) {
	this.crecheFacade = crecheFacade;
	Objects.requireNonNull(this.crecheFacade, "deve informar uma instancia de CrecheFacade");
    }





    public void validar(final EventoDTO dto) throws KidsException {
	this.validarDataDoEvento(dto);
	this.validarCrecheCadastrada(dto);
    }





    private void validarCrecheCadastrada(final EventoDTO dto) throws CrecheInexistenteException {
	this.crecheFacade.buscarCreche(dto.getCrecheId().longValue());
    }





    private void validarDataDoEvento(final EventoDTO dto) throws DataEventoInvalidaException {
	if (dto.getDtRealizacao().compareTo(LocalDateTime.now()) < 0) {
	    throw new DataEventoInvalidaException();
	}
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