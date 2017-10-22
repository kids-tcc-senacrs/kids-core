package com.kids.modulogaleria;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kids.modulogaleria.vo.GaleriaVO;
import com.kids.util.KidsJsonUtil;
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





    @RequestMapping(method = GET, path = "/{crecheId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> get(@PathVariable(required = true) final Long crecheId) {
	try {

	    final List<GaleriaVO> galerias = this.galeriaService.getGaleriasByCrecheId(crecheId);
	    final HttpStatus httpStatus = galerias == null || galerias.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK;
	    return ResponseEntity.status(httpStatus).body(KidsJsonUtil.convertToJson(galerias));

	} catch (final Exception e) {
	    return ResponseEntity.status(HttpStatus.CONFLICT).body(new RestErroVo(e.getMessage()));
	}

    }





    @RequestMapping(method = POST)
    public ResponseEntity<?> save(@RequestBody(required = true) final MultipartFile file) {
	try {
	    if (file != null) {
		this.galeriaService.save(file, file.getOriginalFilename());
	    } else {
		return ResponseEntity.status(HttpStatus.CONFLICT).body("Arquivo nulo ou vazio!");
	    }
	} catch (final Exception e) {
	    return ResponseEntity.status(HttpStatus.CONFLICT).body(new RestErroVo(e.getMessage()));
	}
	return ResponseEntity.status(CREATED).build();
    }

    //final Byte[] fileContent = toObjects(file.getBytes());
    //    final StringBuilder sb = new StringBuilder("data:image/jpg;base64,");
    //    final byte[] base64 = Base64.encodeBase64(file.getBytes(), false);
    //    sb.append(StringUtils.newStringUtf8(base64));
    //    private Byte[] toObjects(byte[] bytesPrim) {
    //	Byte[] bytes = new Byte[bytesPrim.length];
    //	Arrays.setAll(bytes, n -> bytesPrim[n]);
    //	return bytes;
    //    }
}