package com.kids.moduloeventos;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.exception.KidsException;
import com.kids.model.Crianca;
import com.kids.model.Evento;
import com.kids.model.EventoResposta;
import com.kids.model.Usuario;
import com.kids.moduloautenticacao.UsuarioFacade;
import com.kids.modulocreche.CrecheFacade;
import com.kids.modulocrianca.CriancaFacade;
import com.kids.moduloeventos.build.BuildEvento;
import com.kids.moduloeventos.dto.EventoDTO;
import com.kids.moduloeventos.dto.RespostaEventoDTO;
import com.kids.moduloeventos.validate.ValidateEvento;
import com.kids.moduloeventos.vo.EventoVO;
import com.kids.repository.EventoRepository;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private UsuarioFacade usuarioFacade;

    @Autowired
    private CriancaFacade criancaFacade;

    @Autowired
    private CrecheFacade crecheFacade;





    public List<EventoVO> getEventosByUsuarioFamiliarEmAberto(final Long usuarioId) throws KidsException {
	final ValidateEvento validate = new ValidateEvento(usuarioFacade);
	validate.validarUsuarioFamiliar(usuarioId);
	return this.eventoRepository.findEventosEmAberto(usuarioId);
    }





    public List<EventoVO> getEventosByUsuarioFamiliarCancelados(final Long usuarioId) throws KidsException {
	final ValidateEvento validate = new ValidateEvento(usuarioFacade);
	validate.validarUsuarioFamiliar(usuarioId);
	return this.eventoRepository.findEventosEmCancelados(usuarioId);
    }





    public List<EventoVO> getEventosByUsuarioCreche(final Long usuarioId) throws KidsException {
	final ValidateEvento validate = new ValidateEvento(usuarioFacade);
	validate.validarUsuarioCreche(usuarioId);
	return this.eventoRepository.findEventosByUsuarioCreche(usuarioId);
    }





    public void save(final EventoDTO dto) throws KidsException {
	final ValidateEvento validate = new ValidateEvento(this.crecheFacade);
	validate.validarInsert(dto);
	final BuildEvento build = new BuildEvento(this.crecheFacade);
	build.create(dto);
	this.eventoRepository.save(build.getEvento());
    }





    public void update(final EventoDTO dto) throws KidsException {
	final ValidateEvento validate = new ValidateEvento(this.eventoRepository);
	validate.validarUpdate(dto);
	final BuildEvento build = new BuildEvento(this.eventoRepository);
	build.update(dto);
	this.eventoRepository.update(build.getEvento());
    }





    public void saveResposta(final RespostaEventoDTO dto) throws KidsException {
	final Evento evento = this.eventoRepository.findEvento(dto.getEventoId());
	final Usuario usuario = this.usuarioFacade.getUsuarioById(dto.getUsuarioId());
	if (evento == null) {
	    throw new IllegalArgumentException("Evento não encontrado!");
	}
	final Crianca crianca = this.criancaFacade.getBuscarById(dto.getCriancaId());
	if (usuario == null) {
	    throw new IllegalArgumentException("Usuário não encontrado!");
	}
	final EventoResposta resposta = new EventoResposta();
	resposta.setEvento(evento);
	resposta.setCrianca(crianca);
	resposta.setResponsavel(usuario);
	resposta.setStatus(dto.getEventoRespostaStatus());
	resposta.setDtResposta(LocalDateTime.now());
	this.eventoRepository.saveResposta(resposta);
    }

}