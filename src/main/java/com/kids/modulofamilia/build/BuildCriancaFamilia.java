package com.kids.modulofamilia.build;

import java.time.LocalDateTime;
import java.util.Objects;

import com.kids.enumeration.TipoUsuario;
import com.kids.exception.KidsException;
import com.kids.model.Crianca;
import com.kids.model.CriancaFamilia;
import com.kids.model.Familia;
import com.kids.model.Pessoa;
import com.kids.model.Usuario;
import com.kids.moduloautenticacao.UsuarioFacade;
import com.kids.moduloautenticacao.vo.UsuarioNovoVO;
import com.kids.modulocrianca.CriancaFacade;
import com.kids.modulofamilia.vo.FamiliaVO;
import com.kids.repository.FamiliaRepository;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 08/2017
 *
 */
public class BuildCriancaFamilia {

    private CriancaFamilia criancaFamilia = new CriancaFamilia();

    private CriancaFacade criancaFacade;

    private UsuarioFacade usuarioFacade;

    private FamiliaRepository familiaRepository;





    public BuildCriancaFamilia(final CriancaFacade criancaFacade, final UsuarioFacade usuarioFacade, final FamiliaRepository familiaRepository) {
	this.criancaFacade = criancaFacade;
	this.usuarioFacade = usuarioFacade;
	this.familiaRepository = familiaRepository;
	Objects.requireNonNull(this.criancaFacade, "informe uma instancia de CriancaFacade");
	Objects.requireNonNull(this.usuarioFacade, "informe uma instancia de UsuarioFacade");
	Objects.requireNonNull(this.familiaRepository, "informe uma instancia de FamiliaRepository");
    }





    public void associar(final FamiliaVO vo) throws KidsException {
	final Crianca crianca = this.criancaFacade.getCriancaById(vo.getCriancaId());
	final Familia familia = this.getFamilia(vo);
	final Usuario usuario = this.getUsuario(familia.getPessoa());
	this.criancaFamilia.setCrianca(crianca);
	this.criancaFamilia.setFamilia(familia);
	this.criancaFamilia.setUsuario(usuario);
	this.criancaFamilia.setDtVinculo(LocalDateTime.now());
	this.criancaFamilia.setParentesco(vo.getParentesco());
	this.criancaFamilia.setAtivo(vo.getAtivo());
	this.criancaFamilia.setFamiliarNotificado(Boolean.FALSE);
	if (this.criancaFamilia.getFamilia().getPessoa().getEndereco().getId() == null) {
	    this.criancaFamilia.getFamilia().getPessoa().setEndereco(null);
	}
    }





    private Usuario getUsuario(final Pessoa pessoa) {
	return this.usuarioFacade.getUsuarioByPessoa(pessoa);
    }





    private Familia getFamilia(final FamiliaVO vo) throws KidsException {
	final Usuario usuario = this.usuarioFacade.getUsuarioByEmail(vo.getEmail());
	if (usuario == null) {
	    return this.criarUsuarioFamiliar(vo.getNome(), vo.getEmail());
	} else {
	    return this.buscarUsuarioFamiliar(vo.getEmail());
	}
    }





    private Familia buscarUsuarioFamiliar(final String email) {
	final Usuario usuario = this.usuarioFacade.getUsuarioByEmail(email);
	return this.familiaRepository.findFamiliarByUsuario(usuario);
    }





    private Familia criarUsuarioFamiliar(final String nome, final String email) throws KidsException {
	this.usuarioFacade.cadastrar(new UsuarioNovoVO(nome, email, TipoUsuario.FAMILIAR, Boolean.TRUE));
	final Usuario usuario = this.usuarioFacade.getUsuarioByEmail(email);
	return this.familiaRepository.findFamiliarByUsuario(usuario);
    }





    public CriancaFamilia getCriancaFamilia() {
	return criancaFamilia;
    }
}