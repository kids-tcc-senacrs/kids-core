package com.kids.modulocrianca;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.model.Crianca;
import com.kids.repository.CriancaRepository;

@Service
public class CriancaService {

	@Autowired
	private CriancaRepository criancaRepository;



	Crianca save(final CriancaVO vo) throws CriancaJaCadastradaException {
		if (this.criancaInformadaJaPossuiCadastro(vo.getMatricula()))
			throw new CriancaJaCadastradaException();
		final Crianca crianca = this.create(vo);
		return this.criancaRepository.save(crianca);
	}



	private Crianca create(final CriancaVO criancaVO) {
		final Crianca crianca = new Crianca();
		crianca.setMatricula(criancaVO.getMatricula());
		crianca.setNome(criancaVO.getNome());
		crianca.setSexo(criancaVO.getSexo());
		crianca.setDtNascimento(new Date());
		return crianca;
	}



	private boolean criancaInformadaJaPossuiCadastro(final String matricula) {
		return this.criancaRepository.findByMatricula(matricula) == null ? Boolean.FALSE : Boolean.TRUE;
	}
}