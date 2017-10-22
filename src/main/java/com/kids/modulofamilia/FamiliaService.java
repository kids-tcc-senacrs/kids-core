package com.kids.modulofamilia;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.exception.KidsException;
import com.kids.mail.MailService;
import com.kids.model.Creche;
import com.kids.model.Crianca;
import com.kids.model.CriancaFamilia;
import com.kids.model.Usuario;
import com.kids.moduloautenticacao.UsuarioFacade;
import com.kids.modulocrianca.CriancaFacade;
import com.kids.modulofamilia.build.BuildCriancaFamilia;
import com.kids.modulofamilia.dto.FamiliaDTO;
import com.kids.modulofamilia.validate.ValidateFamilia;
import com.kids.repository.CriancaFamiliaRepository;
import com.kids.repository.FamiliaRepository;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 08/2017
 *
 */
@Service
public class FamiliaService {

    @Autowired
    private CriancaFacade criancaFacade;

    @Autowired
    private UsuarioFacade usuarioFacade;

    @Autowired
    private FamiliaRepository familiaRepository;

    @Autowired
    private CriancaFamiliaRepository criancaFamiliaRepository;

    @Autowired
    private MailService mailService;





    public List<Creche> findCrechesByUsuarioFamiliar(final Usuario usuarioFamiliar) {
	return this.criancaFamiliaRepository.findCrechesByUsuarioFamiliar(usuarioFamiliar);
    }





    void save(final FamiliaDTO dto) throws KidsException {
	final ValidateFamilia validateFamilia = new ValidateFamilia(this.criancaFacade, this.usuarioFacade, this.familiaRepository);
	validateFamilia.validarCadastroNovo(dto);
	final BuildCriancaFamilia buildCriancaFamilia = new BuildCriancaFamilia(this.criancaFacade, this.usuarioFacade, this.familiaRepository);
	buildCriancaFamilia.associar(dto);
	this.criancaFamiliaRepository.persist(buildCriancaFamilia.getCriancaFamilia());
	final Crianca crianca = this.criancaFacade.getCriancaById(dto.getCriancaId());
	this.mailService.sendEmailToFamiliarVinculado(dto.getEmail(), "Permissão De Acesso", null, false, crianca.getPessoa().getNome(), dto.getNome());
    }





    public Set<CriancaFamilia> getByCriancaId(final Long criancaId) {
	return this.criancaFamiliaRepository.findByCriancaId(criancaId);
    }





    public void delete(final Long criancaFamiliaId) throws FamiliarInexistenteException {
	final CriancaFamilia criancaFamilia = this.criancaFamiliaRepository.findByCriancaFamiliaId(criancaFamiliaId);
	if (criancaFamilia == null) {
	    throw new FamiliarInexistenteException();
	} else {
	    this.criancaFamiliaRepository.remove(criancaFamilia);
	}
    }

}