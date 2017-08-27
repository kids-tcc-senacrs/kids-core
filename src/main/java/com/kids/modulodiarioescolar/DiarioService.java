package com.kids.modulodiarioescolar;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.enumeration.DiarioTipo;
import com.kids.exception.KidsException;
import com.kids.model.Diario;
import com.kids.modulocreche.CrecheFacade;
import com.kids.modulocrianca.CriancaFacade;
import com.kids.modulodiarioescolar.build.BuildDiario;
import com.kids.modulodiarioescolar.dto.DiarioDTO;
import com.kids.modulodiarioescolar.validate.ValidateDiario;
import com.kids.modulodiarioescolar.vo.DiarioVO;
import com.kids.repository.DiarioRepository;

@Service
public class DiarioService {

    @Autowired
    private DiarioRepository diarioRepository;

    @Autowired
    private CrecheFacade crecheFacade;

    @Autowired
    private CriancaFacade criancaFacade;





    public List<DiarioVO> getDiariosByCreche(final Integer crecheId, final DiarioTipo tipo) {
	return this.diarioRepository.findDiarios(crecheId, tipo);
    }





    public void save(final List<DiarioDTO> dtos) throws KidsException {
	new ValidateDiario(this.diarioRepository).validar(dtos);
	final BuildDiario build = new BuildDiario(this.crecheFacade, this.criancaFacade, this.diarioRepository);
	build.create(dtos);
	final Set<Diario> diarios = build.getDiarios();
	this.diarioRepository.persistOrUpdate(diarios);
    }





    public List<DiarioVO> getDiariosByFamiliar(final Integer usuarioId, final DiarioTipo tipoDiario) {
	return this.diarioRepository.findDiariosByFamiliar(usuarioId, tipoDiario);
    }

}