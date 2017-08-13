package com.kids.modulofamilia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.exception.KidsException;
import com.kids.moduloautenticacao.UsuarioFacade;
import com.kids.modulocrianca.CriancaFacade;
import com.kids.modulofamilia.build.BuildCriancaFamilia;
import com.kids.modulofamilia.validate.ValidateFamilia;
import com.kids.modulofamilia.vo.FamiliaVO;
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





    void save(final FamiliaVO vo) throws KidsException {
	final ValidateFamilia validateFamilia = new ValidateFamilia(this.criancaFacade, this.usuarioFacade);
	validateFamilia.validarCadastroNovo(vo);
	final BuildCriancaFamilia buildCriancaFamilia = new BuildCriancaFamilia(this.criancaFacade, this.usuarioFacade, this.familiaRepository);
	buildCriancaFamilia.associar(vo);
	this.criancaFamiliaRepository.persist(buildCriancaFamilia.getCriancaFamilia());
    }





    public void atualizar(final FamiliaVO vo) throws KidsException {
	throw new UnsupportedOperationException("EM DESENVOLVIMENTO");
    }

}