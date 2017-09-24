package com.kids.modulocomunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.exception.KidsException;
import com.kids.moduloautenticacao.UsuarioFacade;
import com.kids.modulocomunicacao.build.BuildComunicacao;
import com.kids.modulocomunicacao.dto.ComunicacaoDTO;
import com.kids.modulocomunicacao.validate.ValidateComunicacao;
import com.kids.modulocomunicacao.vo.ComunicacaoVO;
import com.kids.modulocreche.CrecheFacade;
import com.kids.repository.ComunicacaoRepository;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 09/2017
 *
 */
@Service
public class ComunicacaoService {

    @Autowired
    private ComunicacaoRepository comunicacaoRepository;

    @Autowired
    private CrecheFacade crecheFacade;

    @Autowired
    private UsuarioFacade usuarioFacade;





    public List<ComunicacaoVO> getComunicacoesByCreche(final Long crecheId) {
	return this.comunicacaoRepository.findComunicacoesByCreche(crecheId);
    }





    public void save(final ComunicacaoDTO dto) throws KidsException {
	final ValidateComunicacao validate = new ValidateComunicacao(comunicacaoRepository, crecheFacade, usuarioFacade);
	validate.validarSave(dto);
	final BuildComunicacao build = new BuildComunicacao(comunicacaoRepository, crecheFacade, usuarioFacade);
	build.create(dto);
	this.comunicacaoRepository.persist(build.getComunicacao());
    }





    public void update(final ComunicacaoDTO dto) throws KidsException {
	final ValidateComunicacao validate = new ValidateComunicacao(comunicacaoRepository, crecheFacade, usuarioFacade);
	validate.validarUpdate(dto);
	final BuildComunicacao build = new BuildComunicacao(comunicacaoRepository, crecheFacade, usuarioFacade);
	build.update(dto);
	this.comunicacaoRepository.update(build.getComunicacao());
    }





    public List<ComunicacaoVO> getComunicacoesByUsuarioFamiliar(final Long usuarioId) {
	return this.comunicacaoRepository.findComunicacoesByUsuarioFamiliar(usuarioId);
    }

}