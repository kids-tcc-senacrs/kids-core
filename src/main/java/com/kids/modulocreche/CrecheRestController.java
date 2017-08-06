package com.kids.modulocreche;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kids.model.Creche;
import com.kids.model.Usuario;
import com.kids.util.KidsConstant;
import com.kids.util.KidsJsonUtil;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 * 
 */
@RestController
@RequestMapping("/creche")
public class CrecheRestController {

    @Autowired
    private CrecheService crecheService;





    @CrossOrigin(origins = { KidsConstant.URL_WEB_DEV, KidsConstant.URL_WEB_PROD })
    @RequestMapping(method = POST, produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCrecheByUsuario(@Valid @RequestBody(required = true) final Usuario usuario) {
	final Creche creche = this.crecheService.getCrecheByUsuario(usuario);
	final HttpStatus httpStatus = creche == null ? HttpStatus.NO_CONTENT : HttpStatus.OK;
	return ResponseEntity.status(httpStatus).body(KidsJsonUtil.convertToJson(creche));
    }

}