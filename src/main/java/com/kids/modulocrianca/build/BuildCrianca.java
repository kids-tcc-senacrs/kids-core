package com.kids.modulocrianca.build;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;

import com.kids.model.Alergia;
import com.kids.model.Contato;
import com.kids.model.Creche;
import com.kids.model.Crianca;
import com.kids.model.Endereco;
import com.kids.model.Medicamento;
import com.kids.model.Pessoa;
import com.kids.modulocreche.CrecheFacade;
import com.kids.modulocrianca.vo.AlergiaVO;
import com.kids.modulocrianca.vo.CrecheVo;
import com.kids.modulocrianca.vo.CriancaAtualizaVO;
import com.kids.modulocrianca.vo.CriancaNovoVO;
import com.kids.repository.CriancaRepository;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 *
 */

public class BuildCrianca {

	private CrecheFacade crecheFacade;

	private CriancaRepository criancaRepository;

	private Crianca crianca = new Crianca();

	public BuildCrianca(final CriancaNovoVO vo, final CrecheFacade crecheFacade, final CriancaRepository criancaRepository) {
		this.crecheFacade = crecheFacade;
		this.criancaRepository = criancaRepository;
		this.crianca.setPessoa(new Pessoa());

		this.crianca.getPessoa().setNome(vo.getPessoa().getNome());
		this.crianca.setMatricula(vo.getMatricula());
		this.crianca.setSexo(vo.getSexo());
		this.crianca.setDtNascimento(new Date());// TODO: RECEBER A DATA E
													// CONVERTER PARA LOCALDATE

		final Endereco endereco = this.buildEndereco(vo, this.crianca.getPessoa());
		final Contato contato = this.buildContato(vo);
		final Creche creche = this.buildCreche(vo.getCreche());
		final Set<Medicamento> medicamentos = this.buildMedicamentos(vo);
		final Set<Alergia> alergias = this.buildAlergias(vo.getAlergias());

		this.crianca.setEndereco(endereco);
		this.crianca.setContato(contato);
		this.crianca.setMedicamentos(medicamentos);
		this.crianca.setAlergias(alergias);
		this.crianca.setCreche(creche);
	}

	public BuildCrianca(final CriancaAtualizaVO vo, final CrecheFacade crecheFacade, final CriancaRepository criancaRepository) {
		this.crecheFacade = crecheFacade;
		this.criancaRepository = criancaRepository;

		this.crianca = this.criancaRepository.findCrianca(vo.getId());
		this.crianca.setMatricula(vo.getMatricula());
		this.crianca.getPessoa().setNome(vo.getPessoa().getNome());
		this.crianca.setSexo(vo.getSexo());
		this.crianca.setDtNascimento(new Date());// TODO: RECEBER A DATA E
													// CONVERTER PARA LOCALDATE

		this.updateEndereco(vo);
		this.updateContato(vo);
		this.updateMedicamentos(vo);
		this.updateAlergias(vo);
	}

	private void updateAlergias(final CriancaAtualizaVO vo) {
		if (this.crianca.getAlergias() == null) {
			this.crianca.setAlergias(new HashSet<>());
		}
		if (vo.getAlergias() == null) {
			this.crianca.setAlergias(null);
		} else {
			vo.getAlergias().forEach(a -> {
				final Alergia alergia = new Alergia();
				alergia.setDescricao(a.getDescricao());
				this.crianca.getAlergias().add(alergia);
			});
		}
	}

	private void updateMedicamentos(final CriancaAtualizaVO vo) {
		if (this.crianca.getMedicamentos() == null) {
			this.crianca.setMedicamentos(new HashSet<>());
		}
		if (vo.getMedicamentos() == null) {
			this.crianca.setMedicamentos(null);
		} else {
			vo.getMedicamentos().forEach(m -> {
				final Medicamento medicamento = new Medicamento();
				medicamento.setNome(m.getNome());
				medicamento.setDosagem(m.getDosagem());
				medicamento.setDtFinal(LocalDate.now());
				medicamento.setIntervaloHoras(m.getIntervaloHoras());
				this.crianca.getMedicamentos().add(medicamento);
			});
		}
	}

	private void updateContato(final CriancaAtualizaVO vo) {
		if (this.crianca.getContato() == null) {
			this.crianca.setContato(new Contato());
		}
		this.crianca.getContato().setResponsavel(vo.getContato().getResponsavel());
		this.crianca.getContato().setEmail(vo.getContato().getEmail());
		this.crianca.getContato().setFonePrincipal(vo.getContato().getFonePrincipal());
		this.crianca.getContato().setFoneOutro(vo.getContato().getFoneOutro());
	}

	private void updateEndereco(CriancaAtualizaVO vo) {
		if (this.crianca.getEndereco() == null) {
			this.crianca.setEndereco(new Endereco());
		}
		this.crianca.getEndereco().setCep(vo.getEndereco().getCep());
		this.crianca.getEndereco().setLogradouro(vo.getEndereco().getLogradouro());
		this.crianca.getEndereco().setLocalizacao(vo.getEndereco().getLocalizacao());
	}

	private Set<Alergia> buildAlergias(final Set<AlergiaVO> alergiasVO) {
		final Set<Alergia> alergias = new HashSet<>();
		if (CollectionUtils.isNotEmpty(alergiasVO)) {
			alergias.forEach(a -> {
				final Alergia alergia = new Alergia();
				alergia.setDescricao(a.getDescricao());
				alergias.add(alergia);
			});
		}
		return alergias;
	}

	private Creche buildCreche(final CrecheVo creche) {
		return this.crecheFacade.getCreche(creche.getId());
	}

	private Set<Medicamento> buildMedicamentos(final CriancaNovoVO vo) {
		final Set<Medicamento> medicamentos = new HashSet<>();
		if (CollectionUtils.isNotEmpty(vo.getMedicamentos())) {
			vo.getMedicamentos().forEach(m -> {
				final Medicamento medicamento = new Medicamento();
				medicamento.setNome(m.getNome());
				medicamento.setDosagem(m.getDosagem());
				medicamento.setIntervaloHoras(m.getIntervaloHoras());
				medicamento.setDtFinal(LocalDate.now());// TODO: RECEBER A DATA
														// E CONVERTER PARA
														// LOCALDATE
					medicamentos.add(medicamento);
				});
		}
		return medicamentos;
	}

	private Contato buildContato(final CriancaNovoVO vo) {
		final Contato contato = new Contato();
		contato.setResponsavel(vo.getContato().getResponsavel());
		contato.setEmail(vo.getContato().getEmail());
		contato.setFonePrincipal(vo.getContato().getFonePrincipal());
		contato.setFoneOutro(vo.getContato().getFoneOutro());
		return contato;
	}

	private Endereco buildEndereco(final CriancaNovoVO vo, final Pessoa pessoa) {
		final Endereco endereco = new Endereco();
		endereco.setPessoa(pessoa);
		endereco.setCep(vo.getEndereco().getCep());
		endereco.setLogradouro(vo.getEndereco().getLogradouro());
		endereco.setLocalizacao(vo.getEndereco().getLocalizacao());
		return endereco;
	}

	public Crianca getCrianca() {
		return crianca;
	}

}