package com.kids.modulocomunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.modulocomunicacao.vo.ComunicacaoVO;
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





    public List<ComunicacaoVO> getComunicacoesByCreche(final Long crecheId) {
	return this.comunicacaoRepository.findComunicacoesByCreche(crecheId);
    }

}