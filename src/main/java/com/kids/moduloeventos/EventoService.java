package com.kids.moduloeventos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.exception.KidsException;
import com.kids.moduloautenticacao.UsuarioFacade;
import com.kids.modulocreche.CrecheFacade;
import com.kids.moduloeventos.build.BuildEvento;
import com.kids.moduloeventos.dto.EventoDTO;
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

}