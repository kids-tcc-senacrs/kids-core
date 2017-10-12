package com.kids.moduloavaliacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.moduloautenticacao.UsuarioFacade;
import com.kids.moduloavaliacao.vo.AvaliacaoVO;
import com.kids.modulocreche.CrecheFacade;
import com.kids.moduloeventos.EventoFacade;
import com.kids.repository.AvaliacaoRepository;
import com.kids.repository.AvisoRepository;

@Service
public class AvaliacaoService {

    @Autowired
    private AvisoRepository avisoRepository;

    @Autowired
    private CrecheFacade crecheFacade;

    @Autowired
    private UsuarioFacade usuarioFacade;

    @Autowired
    private EventoFacade eventoFacade;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;





    public List<AvaliacaoVO> getAvaliacoes(final Long criancaId) {
	return avaliacaoRepository.findAvaliacoes(criancaId);
    }

}