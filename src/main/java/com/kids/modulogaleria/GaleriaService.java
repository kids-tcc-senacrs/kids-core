package com.kids.modulogaleria;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kids.exception.KidsException;
import com.kids.model.Creche;
import com.kids.model.Galeria;
import com.kids.modulocreche.CrecheFacade;
import com.kids.repository.GaleriaRepository;

@Service
public class GaleriaService {

    @Autowired
    private GaleriaRepository galeriaRepository;

    @Autowired
    private CrecheFacade crecheFacade;





    public void upload(final Object object, final Byte[] file, final String fileName) throws KidsException {

	final String[] names = fileName.split("param___creche_id");
	final Long crecheId = Long.valueOf(names[0]);
	final String descricao = names[1];

	final Creche creche = this.crecheFacade.buscarCreche(crecheId);
	final Galeria galeria = new Galeria();
	galeria.setCreche(creche);
	galeria.setImagem(file);
	galeria.setDescricao(descricao);
	galeria.setDtPost(LocalDateTime.now());
	this.galeriaRepository.persist(galeria);
    }

}