package com.kids.modulocrianca.validate;

import java.util.Set;

import org.apache.commons.collections.CollectionUtils;

import com.kids.exception.KidsException;
import com.kids.model.Creche;
import com.kids.model.Crianca;
import com.kids.modulocreche.CrecheFacade;
import com.kids.modulocrianca.vo.AlergiaVO;
import com.kids.modulocrianca.vo.CriancaAtualizaVO;
import com.kids.modulocrianca.vo.CriancaNovoVO;
import com.kids.repository.CriancaRepository;

/**
 * 
 * @author ortiz - lucianoortizsilva@gmail.com
 * @since 08/2017
 *
 */
public class ValidateCrianca {

	private CrecheFacade crecheFacade;

	private CriancaRepository criancaRepository;

	public ValidateCrianca(final CriancaNovoVO vo, final CrecheFacade crecheFacade, final CriancaRepository criancaRepository) throws KidsException {
		this.crecheFacade = crecheFacade;
		this.criancaRepository = criancaRepository;
		this.validar(vo);
	}

	public ValidateCrianca(final CriancaAtualizaVO vo, final CrecheFacade crecheFacade, final CriancaRepository criancaRepository) throws KidsException {
		this.crecheFacade = crecheFacade;
		this.criancaRepository = criancaRepository;
		this.validar(vo);
	}

	private void validar(final CriancaNovoVO vo) throws KidsException {
		final Creche creche = this.crecheFacade.getCreche(vo.getCreche().getId());
		this.validarCrecheCadastrada(creche);
		this.validarCriancaCadastrada(creche, vo.getMatricula());
		this.validarAlergiaDuplicada(vo.getAlergias());
	}

	private void validar(final CriancaAtualizaVO vo) throws KidsException {
		this.validarCriancaCadastrada(vo.getId());
	}

	private void validarCriancaCadastrada(final Long id) throws CriancaInexistenteException {
		final Crianca crianca = this.criancaRepository.findCrianca(id);
		if (crianca == null) {
			throw new CriancaInexistenteException();
		}
	}

	private void validarCrecheCadastrada(final Creche creche) throws CrecheInexistenteException {
		if (creche == null) {
			throw new CrecheInexistenteException();
		}
	}

	private void validarCriancaCadastrada(final Creche creche, final String matricula) throws CriancaJaCadastradaException {
		final Crianca crianca = this.criancaRepository.findCriancasByCrecheAndMatricula(creche, matricula);
		if (crianca != null) {
			throw new CriancaJaCadastradaException();
		}
	}

	private void validarAlergiaDuplicada(final Set<AlergiaVO> alergias) throws AlergiaDuplicadaException {
		if (CollectionUtils.isNotEmpty(alergias)) {
			final ValidaAlergiaAdicionada validaAlergiaAdicionada = new ValidaAlergiaAdicionada();
			for (final AlergiaVO alergia : alergias) {
				validaAlergiaAdicionada.validar(alergia);
			}
		}
	}

}