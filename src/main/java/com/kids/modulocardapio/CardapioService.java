package com.kids.modulocardapio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.modulocardapio.vo.CardapioVO;
import com.kids.modulocreche.CrecheFacade;
import com.kids.repository.CardapioRepository;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 10/2017
 * 
 */
@Service
public class CardapioService {

    @Autowired
    private CrecheFacade crecheFacade;

    @Autowired
    private CardapioRepository cardapioRepository;





    public List<CardapioVO> getCardapiosByCreche(final Long crecheId) {
	return this.cardapioRepository.findCardapiosByCreche(crecheId);
    }

}