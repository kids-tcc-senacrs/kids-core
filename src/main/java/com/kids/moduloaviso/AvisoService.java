package com.kids.moduloaviso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.enumeration.TipoUsuario;
import com.kids.exception.KidsException;
import com.kids.model.Aviso;
import com.kids.model.Usuario;
import com.kids.moduloautenticacao.UsuarioFacade;
import com.kids.moduloaviso.dto.AvisoDTO;
import com.kids.moduloaviso.validate.AvisoInexistenteException;
import com.kids.moduloaviso.vo.AvisoVO;
import com.kids.modulocreche.CrecheFacade;
import com.kids.repository.AvisoRepository;

@Service
public class AvisoService {

    @Autowired
    private AvisoRepository avisoRepository;

    @Autowired
    private CrecheFacade crecheFacade;

    @Autowired
    private UsuarioFacade usuarioFacade;





    public List<AvisoVO> getAvisos(final Long usuarioId) {
	final Usuario usuario = this.usuarioFacade.getUsuarioById(usuarioId);
	if (usuario != null) {
	    if (TipoUsuario.FAMILIAR.equals(usuario.getTipo())) {
		return this.avisoRepository.findAvisosParaFamiliares(usuarioId);
	    } else if (TipoUsuario.CRECHE.equals(usuario.getTipo())) {
		return this.avisoRepository.findAvisosParaCreches(usuarioId);
	    }
	}
	return null;
    }





    public void save(final AvisoDTO dto) throws KidsException {
	final Aviso aviso = new Aviso();
	aviso.setCreche(crecheFacade.buscarCreche(dto.getCrecheId().longValue()));
	aviso.setDescricao(dto.getDescricao());
	aviso.setDtExpiracao(dto.getDtExpiracao());
	aviso.setTipo(dto.getTipo());
	this.avisoRepository.persist(aviso);
    }





    public void delete(final Long id) throws AvisoInexistenteException {
	final Aviso aviso = this.avisoRepository.getAvisoById(id);
	if (aviso == null) {
	    throw new AvisoInexistenteException();
	} else {
	    this.avisoRepository.remove(aviso);
	}

    }

}