package com.kids.modulocardapio;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.model.Cardapio;
import com.kids.modulocardapio.util.TraduzDiaSemana;
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
	final List<CardapioVO> cardapios = this.cardapioRepository.findCardapiosByCreche(crecheId);
	if (CollectionUtils.isNotEmpty(cardapios)) {
	    for (final CardapioVO vo : cardapios) {
		vo.setDiaSemana(TraduzDiaSemana.traduzir(vo.getDiaSemana()));
	    }
	}
	return cardapios;
    }





    public void delete(final Cardapio cardapio) {
	this.cardapioRepository.remove(cardapio);
    }





    public Cardapio getByid(final Long id) {
	return this.cardapioRepository.findById(id);
    }
}