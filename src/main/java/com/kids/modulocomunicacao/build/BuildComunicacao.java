package com.kids.modulocomunicacao.build;

import java.time.LocalDateTime;
import java.util.Objects;

import com.kids.exception.KidsException;
import com.kids.model.Comunicacao;
import com.kids.moduloautenticacao.UsuarioFacade;
import com.kids.modulocomunicacao.dto.ComunicacaoDTO;
import com.kids.modulocreche.CrecheFacade;
import com.kids.repository.ComunicacaoRepository;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 08/2017
 *
 */
public class BuildComunicacao {

    private ComunicacaoRepository comunicacaoRepository;

    private CrecheFacade crecheFacade;

    private UsuarioFacade usuarioFacade;

    private Comunicacao comunicacao;





    public BuildComunicacao(final ComunicacaoRepository comunicacaoRepository, final CrecheFacade crecheFacade, final UsuarioFacade usuarioFacade) {
	this.comunicacaoRepository = comunicacaoRepository;
	this.crecheFacade = crecheFacade;
	this.usuarioFacade = usuarioFacade;
	this.comunicacao = new Comunicacao();
	Objects.requireNonNull(this.comunicacaoRepository, "deve informar uma instancia de ComunicacaoRepository");
	Objects.requireNonNull(this.crecheFacade, "deve informar uma instancia de CrecheFacade");
	Objects.requireNonNull(this.usuarioFacade, "deve informar uma instancia de UsuarioFacade");
    }





    public void create(final ComunicacaoDTO dto) throws KidsException {
	this.comunicacao.setCreche(this.crecheFacade.getCreche(dto.getCrecheId()));
	this.comunicacao.setUsuario(this.usuarioFacade.getUsuarioById(dto.getUsuarioId()));
	this.comunicacao.setTipo(dto.getTipo());
	this.comunicacao.setDescricaoFamiliar(dto.getDescricaoFamiliar());
	this.comunicacao.setDtEnvioFamiliar(LocalDateTime.now());
	this.comunicacao.setCrecheRespondeu(false);
	this.comunicacao.setDescricaoCreche(null);
	this.comunicacao.setDtRespostaCreche(null);
	this.comunicacao.setId(null);
    }





    public Comunicacao getComunicacao() {
	return comunicacao;
    }
}