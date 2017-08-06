package com.kids.modulocrianca;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.enumeration.TipoUsuario;
import com.kids.exception.KidsException;
import com.kids.model.Crianca;
import com.kids.model.Usuario;
import com.kids.moduloautenticacao.UsuarioFacade;
import com.kids.modulocreche.CrecheFacade;
import com.kids.modulocrianca.build.BuildCrianca;
import com.kids.modulocrianca.validate.ValidateCrianca;
import com.kids.modulocrianca.vo.CriancaAtualizaVO;
import com.kids.modulocrianca.vo.CriancaNovoVO;
import com.kids.repository.CriancaRepository;

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





    Crianca save(final CriancaNovoVO vo) throws KidsException {
	new ValidateCrianca(vo, this.crecheFacade, this.criancaRepository);
	final BuildCrianca build = new BuildCrianca(vo, this.crecheFacade, this.criancaRepository);
	return this.criancaRepository.persist(build.getCrianca());
    }





    Crianca update(final CriancaAtualizaVO vo) throws KidsException {
	new ValidateCrianca(vo, this.crecheFacade, this.criancaRepository);
	final BuildCrianca build = new BuildCrianca(vo, this.crecheFacade, this.criancaRepository);
	return this.criancaRepository.update(build.getCrianca());
    }





    Set<Crianca> getCriancasByUsuarioId(final Long usuarioId) {
	final Usuario usuario = this.usuarioFacade.getUsuarioById(usuarioId);
	if (TipoUsuario.CRECHE.equals(usuario.getTipo())) {
	    final Usuario u = this.usuarioFacade.getUsuarioById(usuario.getId());
	    if (u.getAtivo()) {
		return this.criancaRepository.findCriancasByCreche(this.crecheFacade.getCrecheByUsuario(u));
	    }
	} else if (TipoUsuario.FAMILIAR.equals(usuario.getTipo())) {
	    throw new UnsupportedOperationException("Operação indisponível no sistema!");
	}
	return null;
    }
}