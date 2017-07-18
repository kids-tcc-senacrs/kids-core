package com.kids.modulocrianca;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kids.exception.KidsException;
import com.kids.model.Crianca;
import com.kids.modulocrianca.vo.CriancaAtualizaVO;
import com.kids.modulocrianca.vo.CriancaNovoVO;
import com.kids.util.JsonUtil;
import com.kids.util.RestErroVo;
import com.kids.util.RestUtil;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 07/2017
 * 
 */
@RestController
@RequestMapping("/crianca")
public class CriancaRestController {

	@Autowired
	private CriancaService criancaService;



	@RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<?> save(@Valid @RequestBody(required = true) final CriancaNovoVO criancaNovoVO, final Errors errors) {
		try {
			if (RestUtil.existeErroNaRequisicao(errors)) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(RestUtil.getErros(errors));
			} else {
				final Crianca c = this.criancaService.save(criancaNovoVO);
				return ResponseEntity.status(CREATED).body(JsonUtil.convertToJson(c));
			}
		} catch (final KidsException e) {
			final RestErroVo erroVo = new RestErroVo();
			erroVo.addMessage(e.getMessage());
			return ResponseEntity.status(CONFLICT).body(erroVo);
		}
	}



	@RequestMapping(method = PUT, consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@Valid @RequestBody(required = true) final CriancaAtualizaVO criancaAtualizaVO, final Errors errors) {
		try {
			if (RestUtil.existeErroNaRequisicao(errors)) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(RestUtil.getErros(errors));
			} else {
				final Crianca c = this.criancaService.update(criancaAtualizaVO);
				return ResponseEntity.status(OK).body(JsonUtil.convertToJson(c));
			}
		} catch (final KidsException e) {
			final RestErroVo erroVo = new RestErroVo();
			erroVo.addMessage(e.getMessage());
			return ResponseEntity.status(CONFLICT).body(erroVo);
		}
	}
	
}