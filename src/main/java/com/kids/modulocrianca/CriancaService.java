package com.kids.modulocrianca;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.enumeration.TipoUsuario;
import com.kids.exception.KidsException;
import com.kids.model.Creche;
import com.kids.model.Crianca;
import com.kids.model.Familia;
import com.kids.model.Usuario;
import com.kids.moduloautenticacao.UsuarioFacade;
import com.kids.modulocreche.CrecheFacade;
import com.kids.modulocrianca.build.BuildCrianca;
import com.kids.modulocrianca.dto.CriancaAtualizaDTO;
import com.kids.modulocrianca.dto.CriancaNovoDTO;
import com.kids.modulocrianca.validate.ValidateCrianca;
import com.kids.repository.CriancaRepository;
import com.kids.repository.FamiliaRepository;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 *
 */
@Service
public class CriancaService {

    @Autowired
    private CrecheFacade crecheFacade;

    @Autowired
    private UsuarioFacade usuarioFacade;

    @Autowired
    private CriancaRepository criancaRepository;

    @Autowired
    private FamiliaRepository familiaRepository;





    Crianca save(final CriancaNovoDTO vo) throws KidsException {
	new ValidateCrianca(vo, this.crecheFacade, this.criancaRepository);
	final BuildCrianca build = new BuildCrianca(vo, this.crecheFacade, this.criancaRepository);
	return this.criancaRepository.persist(build.getCrianca());
    }





    Crianca update(final CriancaAtualizaDTO vo) throws KidsException {
	new ValidateCrianca(vo, this.crecheFacade, this.criancaRepository);
	final BuildCrianca build = new BuildCrianca(vo, this.crecheFacade, this.criancaRepository);
	return this.criancaRepository.update(build.getCrianca());
    }





    List<Crianca> getCriancasByUsuarioId(final Long usuarioId) {
	final Usuario usuario = this.usuarioFacade.getUsuarioById(usuarioId);
	if (usuario.getAtivo()) {
	    if (TipoUsuario.CRECHE.equals(usuario.getTipo())) {
		final Creche creche = this.crecheFacade.getCrecheByUsuario(usuario);
		return this.criancaRepository.findCriancasByCreche(creche);
	    } else if (TipoUsuario.FAMILIAR.equals(usuario.getTipo())) {
		final Familia familia = this.familiaRepository.findFamiliarByUsuario(usuario);
		return this.criancaRepository.findCriancasByFamiliar(familia);
	    } else {
		throw new UnsupportedOperationException("Tipo de usuário NÃO operado pelo sistema!");
	    }
	}
	return null;
    }
}