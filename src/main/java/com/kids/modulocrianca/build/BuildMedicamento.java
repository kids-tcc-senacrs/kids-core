package com.kids.modulocrianca.build;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;

import com.kids.model.Crianca;
import com.kids.model.Medicamento;
import com.kids.modulocrianca.dto.CriancaAtualizaDTO;
import com.kids.modulocrianca.dto.CriancaNovoDTO;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 08/2017
 *
 */
public class BuildMedicamento {

    private Crianca crianca;





    public BuildMedicamento() {
	super();
    }





    public BuildMedicamento(final Crianca crianca) {
	this.crianca = crianca;
	Objects.requireNonNull(this.crianca, "informe uma intancia de Crianca");
    }





    public void update(final CriancaAtualizaDTO vo) {
	this.updateMedicamentos(vo);
    }





    public Set<Medicamento> create(final CriancaNovoDTO vo) {
	final Set<Medicamento> medicamentos = new HashSet<>();
	if (CollectionUtils.isNotEmpty(vo.getMedicamentos())) {
	    vo.getMedicamentos().forEach(m -> {
		final Medicamento medicamento = new Medicamento();
		medicamento.setNome(m.getNome());
		medicamento.setDosagem(m.getDosagem());
		medicamento.setIntervaloHoras(m.getIntervaloHoras());
		medicamento.setDtFinal(m.getDtFinal());
		medicamentos.add(medicamento);
	    });
	}
	return medicamentos;
    }





    private void adicionarMedicamentos(final CriancaAtualizaDTO vo) {
	vo.getMedicamentos().forEach(m -> {
	    if (m.getId() == null) {
		final Medicamento medicamento = new Medicamento();
		medicamento.setNome(m.getNome());
		medicamento.setDosagem(m.getDosagem());
		medicamento.setDtFinal(m.getDtFinal());
		medicamento.setIntervaloHoras(m.getIntervaloHoras());
		this.crianca.getMedicamentos().add(medicamento);
	    }
	});
    }





    private void updateMedicamentos(final CriancaAtualizaDTO vo) {
	if (this.crianca.getMedicamentos() == null) {
	    this.crianca.setMedicamentos(new HashSet<>());
	}
	if (vo.getMedicamentos() == null) {
	    this.crianca.setMedicamentos(null);
	} else {
	    this.removerMedicamentos(vo);
	    this.adicionarMedicamentos(vo);
	}
    }





    private void removerMedicamentos(final CriancaAtualizaDTO vo) {
	final Set<Long> idMedicamentosQuePermacemNoCadastro = this.getIdMedicamentosQuePermanecemNoCadastro(vo);
	final Set<Long> idMedicamentosQueEstaoCadastradosNoMomento = this.getIdMedicamentosQueEstaoCadastradosNoMomento();
	final Set<Long> idMedicamentosParaRemoverDaBaseDeDados = this.getIdMedicamentosParaRemoverDaBaseDeDados(idMedicamentosQueEstaoCadastradosNoMomento, idMedicamentosQuePermacemNoCadastro);

	final Set<Medicamento> todosMedicamentosCadastradosCopy = new HashSet<>();
	todosMedicamentosCadastradosCopy.addAll(this.crianca.getMedicamentos());

	idMedicamentosParaRemoverDaBaseDeDados.forEach(idParaRemover -> {
	    for (final Medicamento medicamento : todosMedicamentosCadastradosCopy) {
		if (medicamento.getId().equals(idParaRemover)) {
		    this.crianca.getMedicamentos().remove(medicamento);
		}
	    }
	});
    }





    private Set<Long> getIdMedicamentosParaRemoverDaBaseDeDados(final Set<Long> todosCadastrados, final Set<Long> todosQueDeveraoPermanecerNoCadastro) {
	final Set<Long> idMedicamentoParaRemover = new HashSet<>();
	todosCadastrados.forEach(idCadastradoNoMomento -> {
	    if (!todosQueDeveraoPermanecerNoCadastro.contains(idCadastradoNoMomento)) {
		idMedicamentoParaRemover.add(idCadastradoNoMomento);
	    }
	});
	return idMedicamentoParaRemover;
    }





    private Set<Long> getIdMedicamentosQuePermanecemNoCadastro(final CriancaAtualizaDTO vo) {
	final Set<Long> medicamentos = new HashSet<>();
	vo.getMedicamentos().forEach(m -> {
	    if (m.getId() != null) {
		medicamentos.add(m.getId());
	    }
	});
	return medicamentos;
    }





    private Set<Long> getIdMedicamentosQueEstaoCadastradosNoMomento() {
	final Set<Long> medicamentos = new HashSet<>();
	this.crianca.getMedicamentos().forEach(m -> {
	    medicamentos.add(m.getId());
	});
	return medicamentos;
    }
}