package com.kids.modulogaleria;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kids.util.RestErroVo;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 10/2017
 * 
 */
@RestController
@RequestMapping("/galeria")
public class GaleriaRestController {

    @Autowired
    private GaleriaService galeriaService;





    @RequestMapping(method = POST)
    public ResponseEntity<?> save(@RequestBody(required = true) final MultipartFile file) {
	try {
	    if (file != null) {
		final Byte[] fileContent = toObjects(file.getBytes());
		this.galeriaService.upload(123, fileContent, file.getOriginalFilename());
	    } else {
		return ResponseEntity.status(HttpStatus.CONFLICT).body("Arquivo nulo ou vazio!");
	    }
	} catch (final Exception e) {
	    return ResponseEntity.status(HttpStatus.CONFLICT).body(new RestErroVo(e.getMessage()));
	}
	return ResponseEntity.status(CREATED).build();
    }





    private Byte[] toObjects(byte[] bytesPrim) {
	Byte[] bytes = new Byte[bytesPrim.length];
	Arrays.setAll(bytes, n -> bytesPrim[n]);
	return bytes;
    }
}