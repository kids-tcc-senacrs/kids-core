package com.kids.modulocardapio;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.exception.KidsException;
import com.kids.model.Cardapio;
import com.kids.model.CardapioAlimento;
import com.kids.model.Creche;
import com.kids.modulocardapio.dto.AlimentoDTO;
import com.kids.modulocardapio.dto.CardapioDTO;
import com.kids.modulocardapio.util.TraduzDiaSemana;
import com.kids.modulocardapio.vo.AlimentoVO;
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
    private CardapioRepository cardapioRepository;

    @Autowired
    private CrecheFacade crecheFacade;





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





    public List<AlimentoVO> getAlimentosByCardapioId(final Long cardapioId) {
	return this.cardapioRepository.findAlimentosByCardapioId(cardapioId);
    }





    public void save(final CardapioDTO dto) throws KidsException {
	final Creche creche = this.crecheFacade.buscarCreche(dto.getCrecheId().longValue());
	this.validarCardapioduplicado(creche, dto.getDtCardapio());
	final String diaSemana = dto.getDtCardapio().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault()).toUpperCase();
	final Cardapio cardapio = new Cardapio(creche, diaSemana, dto.getDtCardapio());
	for (final AlimentoDTO alimentoDTO : dto.getAlimentos()) {
	    cardapio.getAlimentos().add(new CardapioAlimento(cardapio, alimentoDTO.getNome()));
	}
	this.cardapioRepository.persist(cardapio);
    }





    private void validarCardapioduplicado(final Creche creche, final LocalDate dtCardapio) throws CardapioDuplicadoException {
	final Cardapio cardapio = this.cardapioRepository.findCardapiosByCreche(creche, dtCardapio);
	if (cardapio != null) {
	    throw new CardapioDuplicadoException();
	}
    }

}