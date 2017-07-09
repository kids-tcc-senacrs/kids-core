package com.kids.modulocrianca;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.enumeration.TipoUsuario;
import com.kids.exception.KidsException;
import com.kids.model.Alergia;
import com.kids.model.Contato;
import com.kids.model.Crianca;
import com.kids.model.Endereco;
import com.kids.model.Medicamento;
import com.kids.moduloautenticacao.UsuarioFacade;
import com.kids.modulocrianca.vo.AlergiaVO;
import com.kids.modulocrianca.vo.CriancaVO;
import com.kids.modulocrianca.vo.MedicamentoVO;
import com.kids.repository.CriancaRepository;

@Service
public class CriancaService {

	@Autowired
	private UsuarioFacade usuarioFacade;

	@Autowired
	private CriancaRepository criancaRepository;



	Crianca save(final CriancaVO vo) throws KidsException {
		this.beforeSave(vo);
		return this.criancaRepository.save(this.create(vo));
	}



	private void beforeSave(final CriancaVO vo) throws KidsException {
		this.validarCrecheCadastrada(vo.getCreche().getId());
		this.validarMatriculaDuplicada(vo.getCreche().getId(), vo.getGeral().getMatricula());
		this.validarAlergiaDuplicada(vo.getAlergias());
	}



	private void validarCrecheCadastrada(final Long id) throws CrecheInexistenteException {
		if (this.usuarioFacade.getUsuario(id, TipoUsuario.CRECHE) == null) {
			throw new CrecheInexistenteException(id);
		}
	}



	private void validarMatriculaDuplicada(final Long crecheId, final String matricula) throws CriancaJaCadastradaException {
		if (this.criancaInformadaJaPossuiCadastro(crecheId, matricula)) {
			throw new CriancaJaCadastradaException(matricula);
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
		final Collection<Medicamento> medicamentos = new ArrayList<>();
		medicamentos.addAll(this.createMedicamentos(criancaVO.getMedicamentos()));
		final Collection<Alergia> alergias = new ArrayList<>();
		alergias.addAll(this.createAlergias(criancaVO.getAlergias()));
		crianca.setEndereco(endereco);
		crianca.setContato(contato);
		crianca.setMedicamentos(medicamentos);
		crianca.setAlergias(alergias);
		return crianca;
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



	private boolean criancaInformadaJaPossuiCadastro(final Long crecheId, final String matricula) {
		return this.criancaRepository.findByCrecheIdAndMatricula(crecheId, matricula) == null ? Boolean.FALSE : Boolean.TRUE;
	}
}