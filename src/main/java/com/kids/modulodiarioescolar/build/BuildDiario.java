package com.kids.modulodiarioescolar.build;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;

import com.kids.exception.KidsException;
import com.kids.model.Diario;
import com.kids.modulocreche.CrecheFacade;
import com.kids.modulocrianca.CriancaFacade;
import com.kids.modulodiarioescolar.dto.DiarioDTO;
import com.kids.repository.DiarioRepository;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 08/2017
 *
 */
public class BuildDiario {

    private CrecheFacade crecheFacade;

    private CriancaFacade criancaFacade;

    private DiarioRepository diarioRepository;

    private Set<Diario> diarios = new HashSet<>();





    public BuildDiario(final CrecheFacade crecheFacade, final CriancaFacade criancaFacade, final DiarioRepository diarioRepository) {
	this.crecheFacade = crecheFacade;
	this.criancaFacade = criancaFacade;
	this.diarioRepository = diarioRepository;
	Objects.requireNonNull(this.crecheFacade, "informe uma intancia de CrecheFacade");
	Objects.requireNonNull(this.criancaFacade, "informe uma intancia de CriancaFacade");
	Objects.requireNonNull(this.diarioRepository, "informe uma intancia de DiarioRepository");
    }





    public void create(final List<DiarioDTO> dtos) throws KidsException {
	if (CollectionUtils.isNotEmpty(dtos)) {
	    for (final DiarioDTO dto : dtos) {
		Diario diario = null;
		if (dto.getId() == null) {
		    diario = new Diario();
		    diario.setTipo(dto.getTipo());
		    diario.setCreche(this.crecheFacade.buscarCreche(dto.getCrecheId()));
		    diario.setCrianca(this.criancaFacade.getBuscarById(dto.getCriancaId()));
		} else {
		    diario = this.diarioRepository.getDiarioById(dto.getId());
		}
		diario.setNota(dto.getNota());
		diario.setDtLancamento(LocalDate.now());
		this.diarios.add(diario);
	    }
	}
    }





    public Set<Diario> getDiarios() {
	return this.diarios;
    }

}