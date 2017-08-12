package com.kids.modulocrianca.build;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;

import com.kids.model.Alergia;
import com.kids.model.Crianca;
import com.kids.modulocrianca.vo.CriancaAtualizaVO;
import com.kids.modulocrianca.vo.CriancaNovoVO;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 08/2017
 *
 */
public class BuildAlergia {

    private Crianca crianca;





    public BuildAlergia(final Crianca crianca) {
	this.crianca = crianca;
	Objects.requireNonNull(this.crianca, "informe uma intancia de Crianca");
    }





    public BuildAlergia() {
	super();
    }





    public void update(final CriancaAtualizaVO vo) {
	this.updateAlergia(vo);
    }





    public Set<Alergia> create(final CriancaNovoVO vo) {
	final Set<Alergia> alergias = new HashSet<>();
	if (CollectionUtils.isNotEmpty(vo.getAlergias())) {
	    vo.getAlergias().forEach(a -> {
		final Alergia alergia = new Alergia();
		alergia.setDescricao(a.getDescricao());
		alergias.add(alergia);
	    });
	}
	return alergias;
    }





    private void adicionarAlergias(final CriancaAtualizaVO vo) {
	vo.getAlergias().forEach(a -> {
	    if (a.getId() == null) {
		final Alergia alergia = new Alergia();
		alergia.setDescricao(a.getDescricao());
		this.crianca.getAlergias().add(alergia);
	    }
	});
    }





    private void updateAlergia(final CriancaAtualizaVO vo) {
	if (this.crianca.getAlergias() == null) {
	    this.crianca.setAlergias(new HashSet<>());
	}
	if (vo.getAlergias() == null) {
	    this.crianca.setAlergias(null);
	} else {
	    this.removerAlergias(vo);
	    this.adicionarAlergias(vo);
	}
    }





    private void removerAlergias(final CriancaAtualizaVO vo) {
	final Set<Long> idAlergiasQuePermacemNoCadastro = this.getIdAlergiasQuePermanecemNoCadastro(vo);
	final Set<Long> idAlergiasQueEstaoCadastradosNoMomento = this.getIdAlergiasQueEstaoCadastradosNoMomento();
	final Set<Long> idAlergiasParaRemoverDaBaseDeDados = this.getIdAlergiasParaRemoverDaBaseDeDados(idAlergiasQueEstaoCadastradosNoMomento, idAlergiasQuePermacemNoCadastro);

	final Set<Alergia> todasAlergiasCadastradasCopy = new HashSet<>();
	todasAlergiasCadastradasCopy.addAll(this.crianca.getAlergias());

	idAlergiasParaRemoverDaBaseDeDados.forEach(idParaRemover -> {
	    for (final Alergia alergia : todasAlergiasCadastradasCopy) {
		if (alergia.getId().equals(idParaRemover)) {
		    this.crianca.getAlergias().remove(alergia);
		}
	    }
	});
    }





    private Set<Long> getIdAlergiasParaRemoverDaBaseDeDados(final Set<Long> todasCadastradas, final Set<Long> todasQueDeveraoPermanecerNoCadastro) {
	final Set<Long> idAlergiasParaRemover = new HashSet<>();
	todasCadastradas.forEach(idCadastradaNoMomento -> {
	    if (!todasQueDeveraoPermanecerNoCadastro.contains(idCadastradaNoMomento)) {
		idAlergiasParaRemover.add(idCadastradaNoMomento);
	    }
	});
	return idAlergiasParaRemover;
    }





    private Set<Long> getIdAlergiasQuePermanecemNoCadastro(final CriancaAtualizaVO vo) {
	final Set<Long> idAlergias = new HashSet<>();
	vo.getAlergias().forEach(a -> {
	    if (a.getId() != null) {
		idAlergias.add(a.getId());
	    }
	});
	return idAlergias;
    }





    private Set<Long> getIdAlergiasQueEstaoCadastradosNoMomento() {
	final Set<Long> alergias = new HashSet<>();
	this.crianca.getAlergias().forEach(a -> {
	    alergias.add(a.getId());
	});
	return alergias;
    }
}