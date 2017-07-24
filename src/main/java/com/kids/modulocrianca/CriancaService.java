package com.kids.modulocrianca;

import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.enumeration.TipoUsuario;
import com.kids.exception.KidsException;
import com.kids.model.Creche;
import com.kids.model.Crianca;
import com.kids.model.Usuario;
import com.kids.moduloautenticacao.UsuarioFacade;
import com.kids.modulocreche.CrecheFacade;
import com.kids.modulocrianca.build.BuildCrianca;
import com.kids.modulocrianca.vo.AlergiaVO;
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
	this.beforeSave(vo);
	final BuildCrianca build = new BuildCrianca(vo, this.crecheFacade, this.criancaRepository);
	return this.criancaRepository.save(build.getCrianca());
    }





    Crianca update(final CriancaAtualizaVO vo) throws KidsException {
	this.beforeUpdate(vo);
	final BuildCrianca build = new BuildCrianca(vo, this.crecheFacade, this.criancaRepository);
	return this.criancaRepository.update(build.getCrianca());
    }





    public Crianca get(final Long id) {
	return this.criancaRepository.find(id);
    }





    private void beforeSave(final CriancaNovoVO vo) throws KidsException {
	final Creche creche = this.crecheFacade.get(vo.getCreche().getId());
	this.validarCrecheCadastrada(creche);
	this.validarAlergiaDuplicada(vo.getAlergias());
    }





    private void beforeUpdate(final CriancaAtualizaVO vo) throws KidsException {
	this.validarCriancaCadastrada(vo.getId());
    }





    private void validarCriancaCadastrada(final Long id) throws CriancaInexistenteException {
	final Crianca crianca = this.get(id);
	if (crianca == null) {
	    throw new CriancaInexistenteException();
	}
    }





    private void validarCrecheCadastrada(final Creche creche) throws CrecheInexistenteException {
	if (creche == null) {
	    throw new CrecheInexistenteException();
	}
    }





    private void validarAlergiaDuplicada(final Set<AlergiaVO> alergias) throws AlergiaDuplicadaException {
	if (CollectionUtils.isNotEmpty(alergias)) {
	    final ValidaAlergiaAdicionada validaAlergiaAdicionada = new ValidaAlergiaAdicionada();
	    for (final AlergiaVO alergia : alergias) {
		validaAlergiaAdicionada.validar(alergia);
	    }
	}
    }





    public Set<Crianca> getCriancasByUsuario(final Usuario usuario) {
	if (TipoUsuario.CRECHE.equals(usuario.getTipo())) {
	    final Usuario u = this.usuarioFacade.getUsuarioById(usuario.getId());
	    if (u.getAtivo()) {
		return this.criancaRepository.findCriancasByCreche(this.crecheFacade.getCrecheByUsuario(u));
	    }
	} else if (TipoUsuario.FAMILIAR.equals(usuario.getTipo())) {
	    return null;
	}
	return null;
    }

}