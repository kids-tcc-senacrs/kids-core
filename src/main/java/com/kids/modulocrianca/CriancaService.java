package com.kids.modulocrianca;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.exception.KidsException;
import com.kids.model.Alergia;
import com.kids.model.Contato;
import com.kids.model.Creche;
import com.kids.model.Crianca;
import com.kids.model.Endereco;
import com.kids.model.Medicamento;
import com.kids.modulocreche.CrecheFacade;
import com.kids.modulocrianca.vo.AlergiaVO;
import com.kids.modulocrianca.vo.CrecheVo;
import com.kids.modulocrianca.vo.CriancaVO;
import com.kids.modulocrianca.vo.MedicamentoVO;
import com.kids.repository.CriancaRepository;

@Service
public class CriancaService {

	@Autowired
	private CrecheFacade crecheFacade;

	@Autowired
	private CriancaRepository criancaRepository;



	Crianca save(final CriancaVO vo) throws KidsException {
		this.beforeSave(vo);
		return this.criancaRepository.save(this.create(vo));
	}



	private void beforeSave(final CriancaVO vo) throws KidsException {
		final Creche creche = this.crecheFacade.get(vo.getCreche().getId());
		this.validarCrecheCadastrada(creche);
		this.validarAlergiaDuplicada(vo.getAlergias());
	}



	private void validarCrecheCadastrada(final Creche creche) throws CrecheInexistenteException {
		if (creche == null) {
			throw new CrecheInexistenteException();
		}
	}



	private void validarAlergiaDuplicada(final List<AlergiaVO> alergias) throws AlergiaDuplicadaException {
		if (CollectionUtils.isNotEmpty(alergias)) {
			final ValidaAlergiaAdicionada validaAlergiaAdicionada = new ValidaAlergiaAdicionada();
			for (final AlergiaVO alergia : alergias) {
				validaAlergiaAdicionada.validar(alergia);
			}
		}
	}



	private Crianca create(final CriancaVO criancaVO) {
		final Crianca crianca = new Crianca();
		crianca.setMatricula(criancaVO.getGeral().getMatricula());
		crianca.setNome(criancaVO.getGeral().getNome());
		crianca.setSexo(criancaVO.getGeral().getSexo());
		crianca.setDtNascimento(new Date());// TODO: CONVERTER DATE
		
		final Endereco endereco = new Endereco();
		endereco.setCep(criancaVO.getEndereco().getCep());
		endereco.setLogradouro(criancaVO.getEndereco().getLogradouro());
		endereco.setLocalizacao(criancaVO.getEndereco().getLocalizacao());
		
		final Contato contato = new Contato();
		contato.setResponsavel(criancaVO.getContato().getResponsavel());
		contato.setEmail(criancaVO.getContato().getEmail());
		contato.setFonePrincipal(criancaVO.getContato().getFonePrincipal());
		contato.setFoneOutro(criancaVO.getContato().getFoneOutro());
		
		final Set<Medicamento> medicamentos = new HashSet<>();
		medicamentos.addAll(this.createMedicamentos(criancaVO.getMedicamentos()));
		
		final Set<Creche> creches = new HashSet<>();
		creches.addAll(this.createCreches(criancaVO.getCreche()));
		
		final Set<Alergia> alergias = new HashSet<>();
		alergias.addAll(this.createAlergias(criancaVO.getAlergias()));
		
		crianca.setEndereco(endereco);
		crianca.setContato(contato);
		crianca.setMedicamentos(medicamentos);
		crianca.setAlergias(alergias);
		crianca.setCreches(creches);
		
		return crianca;
	}



	private Collection<Creche> createCreches(final CrecheVo creche) {
		final List<Creche> creches = new ArrayList<>();
		creches.add(this.crecheFacade.get(creche.getId()));
		return creches;
	}



	private Collection<Alergia> createAlergias(final List<AlergiaVO> alergiasVO) {
		final List<Alergia> alergias = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(alergiasVO)) {
			alergiasVO.forEach(a -> {
				final Alergia alergia = new Alergia();
				alergia.setDescricao(a.getDescricao());
				alergias.add(alergia);
			});
		}
		return alergias;
	}



	private Collection<Medicamento> createMedicamentos(final List<MedicamentoVO> medicamentosVO) {
		final List<Medicamento> medicamentos = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(medicamentosVO)) {
			medicamentosVO.forEach(m -> {
				final Medicamento medicamento = new Medicamento();
				medicamento.setNome(m.getNome());
				medicamento.setDosagem(m.getDosagem());
				medicamento.setIntervaloHoras(m.getIntervaloHoras());
				medicamento.setDtFinal(new Date());// TODO: CONVERTER DATE
				medicamentos.add(medicamento);
			});
		}
		return medicamentos;
	}
}