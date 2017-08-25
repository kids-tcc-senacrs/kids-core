package com.kids.modulodiarioescolar;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kids.enumeration.DiarioTipo;
import com.kids.model.Diario;
import com.kids.util.KidsJsonUtil;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 08/2017
 * 
 */
@RestController
@RequestMapping("/diario")
public class DiarioRestController {

    @Autowired
    private DiarioService diarioService;





    @RequestMapping(method = GET, path = "/{crecheId}/{tipo}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getDiarios(@PathVariable(required = true) final Long crecheId, @PathVariable(required = true) final DiarioTipo tipo) {
	final List<Diario> diarios = this.diarioService.getDiarios(crecheId, tipo);
	return ResponseEntity.status(HttpStatus.OK).body(KidsJsonUtil.convertToJson(diarios));//
    }

}