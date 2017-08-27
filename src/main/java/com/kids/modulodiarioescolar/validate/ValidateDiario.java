package com.kids.modulodiarioescolar.validate;

import java.util.List;
import java.util.Objects;

import org.apache.commons.collections.CollectionUtils;

import com.kids.exception.KidsException;
import com.kids.model.Diario;
import com.kids.modulodiarioescolar.dto.DiarioDTO;
import com.kids.repository.DiarioRepository;

public class ValidateDiario {

    private DiarioRepository diarioRepository;





    public ValidateDiario(final DiarioRepository diarioRepository) {
	this.diarioRepository = diarioRepository;
	Objects.requireNonNull(this.diarioRepository, "deve informar uma instancia de DiarioRepository");
    }





    public void validar(final List<DiarioDTO> dtos) throws KidsException {
	if (CollectionUtils.isNotEmpty(dtos)) {
	    for (final DiarioDTO dto : dtos) {
		if (dto.getId() == null) {
		    this.validarDiarioDuplicadoQuandoIdNaoInformado(dto);
		} else {
		    this.validarDiarioInexistente(dto.getId());
		}
	    }
	}
    }





    private void validarDiarioDuplicadoQuandoIdNaoInformado(final DiarioDTO dto) throws DiarioDuplicadoException {
	final Diario diario = this.diarioRepository.findDiario(dto.getCrecheId(), dto.getCriancaId(), dto.getTipo());
	if (diario != null) {
	    throw new DiarioDuplicadoException(dto.getCrecheId(), dto.getCriancaId(), dto.getTipo());
	}
    }





    private void validarDiarioInexistente(final Long diarioId) throws DiarioInexistenteException {
	final Diario diario = this.diarioRepository.getDiarioById(diarioId);
	if (diario == null) {
	    throw new DiarioInexistenteException();
	}
    }

}