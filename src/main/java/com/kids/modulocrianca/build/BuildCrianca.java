package com.kids.modulocrianca.build;

import java.util.Set;

import com.kids.model.Alergia;
import com.kids.model.Contato;
import com.kids.model.Creche;
import com.kids.model.Crianca;
import com.kids.model.Endereco;
import com.kids.model.Medicamento;
import com.kids.model.Pessoa;
import com.kids.modulocreche.CrecheFacade;
import com.kids.modulocrianca.dto.CrecheDTO;
import com.kids.modulocrianca.dto.CriancaAtualizaDTO;
import com.kids.modulocrianca.dto.CriancaNovoDTO;
import com.kids.modulocrianca.dto.EnderecoDTO;
import com.kids.repository.CriancaRepository;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 *
 */

public class BuildCrianca {

    private CrecheFacade crecheFacade;

    private CriancaRepository criancaRepository;

    private Crianca crianca = new Crianca();





    public BuildCrianca(final CriancaNovoDTO vo, final CrecheFacade crecheFacade, final CriancaRepository criancaRepository) {
	this.crecheFacade = crecheFacade;
	this.criancaRepository = criancaRepository;
	this.crianca.setPessoa(new Pessoa());

	this.crianca.getPessoa().setNome(vo.getPessoa().getNome());
	this.crianca.setMatricula(vo.getMatricula());
	this.crianca.setSexo(vo.getSexo());
	//this.crianca.setFoto(vo.getFoto());//TODO: VAI SER ADICIONADO EM UM FUTURO SPRINT
	this.crianca.setDtNascimento(vo.getDtNascimento());

	final Endereco endereco = this.buildEndereco(vo, this.crianca.getPessoa());
	final Contato contato = this.buildContato(vo);
	final Creche creche = this.buildCreche(vo.getCreche());
	final Set<Medicamento> medicamentos = this.buildMedicamentos(vo);
	final Set<Alergia> alergias = this.buildAlergias(vo);

	this.crianca.getPessoa().setEndereco(endereco);
	this.crianca.setContato(contato);
	this.crianca.setMedicamentos(medicamentos);
	this.crianca.setAlergias(alergias);
	this.crianca.setCreche(creche);
    }





    private Set<Alergia> buildAlergias(final CriancaNovoDTO vo) {
	return new BuildAlergia().create(vo);
    }





    private Set<Medicamento> buildMedicamentos(final CriancaNovoDTO vo) {
	return new BuildMedicamento().create(vo);
    }





    public BuildCrianca(final CriancaAtualizaDTO vo, final CrecheFacade crecheFacade, final CriancaRepository criancaRepository) {
	this.crecheFacade = crecheFacade;
	this.criancaRepository = criancaRepository;

	this.crianca = this.criancaRepository.findCriancaById(vo.getId());
	this.crianca.setMatricula(vo.getMatricula());
	this.crianca.getPessoa().setNome(vo.getPessoa().getNome());
	this.crianca.setSexo(vo.getSexo());
	//this.crianca.setFoto(vo.getFoto());//TODO: VAI SER ADICIONADO EM UM FUTURO SPRINT
	this.crianca.setDtNascimento(vo.getDtNascimento());

	this.updateEndereco(vo);
	this.updateContato(vo);
	this.updateMedicamentos(vo);
	this.updateAlergias(vo);
    }





    private void updateMedicamentos(final CriancaAtualizaDTO vo) {
	final BuildMedicamento buildMedicamento = new BuildMedicamento(this.crianca);
	buildMedicamento.update(vo);
    }





    private void updateAlergias(final CriancaAtualizaDTO vo) {
	final BuildAlergia buildAlergia = new BuildAlergia(this.crianca);
	buildAlergia.update(vo);
    }





    private void updateContato(final CriancaAtualizaDTO vo) {
	if (this.crianca.getContato() == null) {
	    this.crianca.setContato(new Contato());
	}
	this.crianca.getContato().setResponsavel(vo.getContato().getResponsavel());
	this.crianca.getContato().setEmail(vo.getContato().getEmail());
	this.crianca.getContato().setFonePrincipal(vo.getContato().getFonePrincipal());
	this.crianca.getContato().setFoneOutro(vo.getContato().getFoneOutro());
    }





    private void updateEndereco(CriancaAtualizaDTO vo) {
	if (this.crianca.getPessoa().getEndereco() == null) {
	    this.crianca.getPessoa().setEndereco(new Endereco());
	}
	this.crianca.getPessoa().getEndereco().setCep(vo.getPessoa().getEndereco().getCep());
	this.crianca.getPessoa().getEndereco().setLogradouro(vo.getPessoa().getEndereco().getLogradouro());
	this.crianca.getPessoa().getEndereco().setLocalizacao(vo.getPessoa().getEndereco().getLocalizacao());
    }





    private Creche buildCreche(final CrecheDTO creche) {
	return this.crecheFacade.getCreche(creche.getId());
    }





    private Contato buildContato(final CriancaNovoDTO vo) {
	final Contato contato = new Contato();
	contato.setResponsavel(vo.getContato().getResponsavel());
	contato.setEmail(vo.getContato().getEmail());
	contato.setFonePrincipal(vo.getContato().getFonePrincipal());
	contato.setFoneOutro(vo.getContato().getFoneOutro());
	return contato;
    }





    private Endereco buildEndereco(final CriancaNovoDTO vo, final Pessoa pessoa) {
	final Endereco endereco = new Endereco();
	endereco.setPessoa(pessoa);
	if (vo.getPessoa().getEndereco() == null)
	    vo.getPessoa().setEndereco(new EnderecoDTO());
	endereco.setCep(vo.getPessoa().getEndereco().getCep());
	endereco.setLogradouro(vo.getPessoa().getEndereco().getLogradouro());
	endereco.setLocalizacao(vo.getPessoa().getEndereco().getLocalizacao());
	return endereco;
    }





    public Crianca getCrianca() {
	return crianca;
    }

}