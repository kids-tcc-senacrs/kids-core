package com.kids.tcc.prepara.bancodedados;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * WS criado para preparar a base dados para realizar testes
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 09/2017
 * 
 */
@RestController
@RequestMapping("/db")
public class PreparaBaseDadoRestController {

	@Autowired
	private PreparaBaseDadoRepository repository;

	@RequestMapping(method = GET, path = "/{senha}")
	public ResponseEntity<?> prepararBaseDados(final @PathVariable(required = true) Integer senha) {
		if (Integer.valueOf(12345).equals(senha)) {
			this.repository.updateDB();
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}