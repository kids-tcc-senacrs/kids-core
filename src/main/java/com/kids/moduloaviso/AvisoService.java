package com.kids.moduloaviso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.exception.KidsException;
import com.kids.model.Aviso;
import com.kids.moduloaviso.dto.AvisoDTO;
import com.kids.moduloaviso.vo.AvisoVO;
import com.kids.modulocreche.CrecheFacade;
import com.kids.repository.AvisoRepository;

@Service
public class AvisoService {

    @Autowired
    private AvisoRepository avisoRepository;

    @Autowired
    private CrecheFacade crecheFacade;





    public List<AvisoVO> getAvisosNaoExpirados(final Long usuarioId) {
	return this.avisoRepository.findAllNaoExpirados(usuarioId);
    }





    public void save(final AvisoDTO dto) throws KidsException {
	final Aviso aviso = new Aviso();
	aviso.setCreche(crecheFacade.buscarCreche(dto.getCrecheId().longValue()));
	aviso.setDescricao(dto.getDescricao());
	aviso.setDtExpiracao(dto.getDtExpiracao());
	aviso.setTipo(dto.getTipo());
	this.avisoRepository.persist(aviso);
    }

}