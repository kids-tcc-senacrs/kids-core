package com.kids.modulofamilia.validate;

import java.util.Objects;

import com.kids.enumeration.TipoUsuario;
import com.kids.exception.KidsException;
import com.kids.model.Crianca;
import com.kids.model.CriancaFamilia;
import com.kids.model.Usuario;
import com.kids.moduloautenticacao.UsuarioFacade;
import com.kids.modulocrianca.CriancaFacade;
import com.kids.modulofamilia.vo.FamiliaVO;
import com.kids.repository.FamiliaRepository;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 08/2017
 *
 */
public class ValidateFamilia {

    private CriancaFacade criancaFacade;

    private UsuarioFacade usuarioFacade;

    private FamiliaRepository familiaRepository;





    public ValidateFamilia(final CriancaFacade criancaFacade, final UsuarioFacade usuarioFacade, final FamiliaRepository familiaRepository) {
	this.criancaFacade = criancaFacade;
	this.usuarioFacade = usuarioFacade;
	this.familiaRepository = familiaRepository;
	Objects.requireNonNull(this.criancaFacade, "informe uma instancia de CriancaFacade");
	Objects.requireNonNull(this.usuarioFacade, "informe uma instancia de UsuarioFacade");
	Objects.requireNonNull(this.familiaRepository, "informe uma instancia de FamiliaRepository");
    }





    public void validarCadastroNovo(final FamiliaVO vo) throws KidsException {
	this.validarCrianca(vo.getCriancaId());
	this.validarTipoUsuario(vo.getEmail());
	this.validarEmailAceito(vo.getEmail());
	this.validarUsuarioJaVinculado(vo.getEmail(), vo.getCriancaId());
    }





    private void validarUsuarioJaVinculado(final String email, final Long criancaId) throws UsuarioJaVinculadoException {
	final Usuario usuario = this.usuarioFacade.getUsuarioByEmail(email);
	final CriancaFamilia criancaFamilia = this.familiaRepository.findCriancaFamilia(usuario, criancaId);
	if (criancaFamilia != null) {
	    throw new UsuarioJaVinculadoException();
	}
    }





    private void validarEmailAceito(final String email) throws DominioEmailInvalidoException {
	final String emailCompleto[] = email.trim().split("@");
	final String dominio[] = emailCompleto[1].split("\\.");
	if (!(dominio.length == 2) || !"gmail".equals(dominio[0]) || !"com".equals(dominio[1])) {
	    throw new DominioEmailInvalidoException();
	}
    }





    private void validarTipoUsuario(final String email) throws TipoUsuarioInvalidoException {
	final Usuario usuario = this.usuarioFacade.getUsuarioByEmail(email);
	if (usuario != null && TipoUsuario.CRECHE.equals(usuario.getTipo())) {
	    throw new TipoUsuarioInvalidoException();
	}
    }





    private void validarCrianca(final Long criancaId) throws CriancaInexistenteException {
	final Crianca crianca = this.criancaFacade.getCriancaById(criancaId);
	if (crianca == null) {
	    throw new CriancaInexistenteException();
	}
    }

}