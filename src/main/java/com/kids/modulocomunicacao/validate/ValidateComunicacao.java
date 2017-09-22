package com.kids.modulocomunicacao.validate;

import java.util.Objects;

import com.kids.enumeration.TipoUsuario;
import com.kids.exception.KidsException;
import com.kids.model.Usuario;
import com.kids.moduloautenticacao.UsuarioFacade;
import com.kids.moduloautenticacao.validate.UsuarioInexistenteException;
import com.kids.modulocomunicacao.dto.ComunicacaoDTO;
import com.kids.modulocreche.CrecheFacade;
import com.kids.modulocrianca.validate.CrecheInexistenteException;
import com.kids.repository.ComunicacaoRepository;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 09/2017
 *
 */
public class ValidateComunicacao {

    private ComunicacaoRepository comunicacaoRepository;

    private CrecheFacade crecheFacade;

    private UsuarioFacade usuarioFacade;





    public ValidateComunicacao(final ComunicacaoRepository comunicacaoRepository, final CrecheFacade crecheFacade, final UsuarioFacade usuarioFacade) {
	this.comunicacaoRepository = comunicacaoRepository;
	this.crecheFacade = crecheFacade;
	this.usuarioFacade = usuarioFacade;
	Objects.requireNonNull(this.comunicacaoRepository, "deve informar uma instancia de ComunicacaoRepository");
	Objects.requireNonNull(this.crecheFacade, "deve informar uma instancia de CrecheFacade");
	Objects.requireNonNull(this.usuarioFacade, "deve informar uma instancia de UsuarioFacade");
    }





    public void validarSave(final ComunicacaoDTO dto) throws KidsException {
	this.validarCreche(dto);
	this.validarUsuario(dto);
	this.validarTipoUsuario(dto);
    }





    private void validarTipoUsuario(final ComunicacaoDTO dto) throws TipoUsuarioNaoPodeCriarComunicacaoException {
	final Usuario usuario = this.usuarioFacade.getUsuarioById(dto.getUsuarioId());
	if (TipoUsuario.CRECHE.equals(usuario.getTipo())) {
	    throw new TipoUsuarioNaoPodeCriarComunicacaoException();
	}
    }





    private void validarUsuario(final ComunicacaoDTO dto) throws UsuarioInexistenteException {
	this.usuarioFacade.buscarUsuarioById(dto.getUsuarioId());
    }





    private void validarCreche(final ComunicacaoDTO dto) throws CrecheInexistenteException {
	this.crecheFacade.buscarCreche(dto.getCrecheId());
    }

}