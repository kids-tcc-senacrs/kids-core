package com.kids.moduloaviso;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.enumeration.AvisoTipo;
import com.kids.enumeration.TipoUsuario;
import com.kids.exception.KidsException;
import com.kids.model.Aviso;
import com.kids.model.Usuario;
import com.kids.moduloautenticacao.UsuarioFacade;
import com.kids.moduloaviso.dto.AvisoDTO;
import com.kids.moduloaviso.validate.AvisoInexistenteException;
import com.kids.moduloaviso.vo.AvisoVO;
import com.kids.modulocreche.CrecheFacade;
import com.kids.moduloeventos.EventoFacade;
import com.kids.moduloeventos.vo.RespostaEventoVO;
import com.kids.repository.AvisoRepository;
import com.kids.util.KidsDateUtil;

@Service
public class AvisoService {

    @Autowired
    private AvisoRepository avisoRepository;

    @Autowired
    private CrecheFacade crecheFacade;

    @Autowired
    private UsuarioFacade usuarioFacade;

    @Autowired
    private EventoFacade eventoFacade;





    public List<AvisoVO> getAvisos(final Long usuarioId) {
	final Usuario usuario = this.usuarioFacade.getUsuarioById(usuarioId);
	if (usuario != null) {
	    if (TipoUsuario.FAMILIAR.equals(usuario.getTipo())) {
		final List<AvisoVO> avisos = new ArrayList<>();
		final List<RespostaEventoVO> respostas = this.eventoFacade.getEventosComPresencaConfirmada(usuarioId);
		avisos.addAll(this.avisoRepository.findAvisosParaFamiliares(usuarioId));
		if (CollectionUtils.isNotEmpty(respostas)) {
		    for (final RespostaEventoVO resposta : respostas) {
			final AvisoVO avisoVO = new AvisoVO();
			avisoVO.setCrecheNome(resposta.getCrecheNome());
			avisoVO.setTipo(AvisoTipo.INFORMACAO.name());
			final StringBuilder desc = new StringBuilder();
			desc.append("O aluno(a) ");
			desc.append(resposta.getCriancaNome()).append(", ");
			desc.append("possui presença confirmada no evento: ");
			desc.append(resposta.getEventoNome()).append(".");
			desc.append("Data: ").append(KidsDateUtil.formater(resposta.getDtRealizacao(), "dd-MM-yyyy HH:mm"));
			avisoVO.setDescricao(desc.toString());
			avisos.add(avisoVO);
		    }
		}
		return avisos;
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