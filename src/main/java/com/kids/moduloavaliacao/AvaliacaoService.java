package com.kids.moduloavaliacao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.exception.KidsException;
import com.kids.model.Avaliacao;
import com.kids.moduloavaliacao.dto.AvaliacaoDTO;
import com.kids.moduloavaliacao.vo.AvaliacaoVO;
import com.kids.modulocreche.CrecheFacade;
import com.kids.modulocrianca.CriancaFacade;
import com.kids.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService {

    @Autowired
    private CrecheFacade crecheFacade;

    @Autowired
    private CriancaFacade criancaFacade;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;





    public List<AvaliacaoVO> getAvaliacoes(final Long criancaId) {
	return avaliacaoRepository.findAvaliacoes(criancaId);
    }





    public void save(final AvaliacaoDTO dto) throws KidsException {
	this.crecheFacade.buscarCreche(dto.getCrecheId().longValue());
	this.criancaFacade.getBuscarById(dto.getCriancaId().longValue());
	final Avaliacao avaliacao = new Avaliacao();
	avaliacao.setCreche(this.crecheFacade.getCreche(dto.getCrecheId().longValue()));
	avaliacao.setCrianca(this.criancaFacade.getCriancaById(dto.getCriancaId().longValue()));
	avaliacao.setDescricao(dto.getDescricao());
	avaliacao.setDtAvaliacao(LocalDate.now());
	this.avaliacaoRepository.save(avaliacao);
    }

}