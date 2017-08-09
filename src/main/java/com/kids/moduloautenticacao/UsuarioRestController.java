package com.kids.moduloautenticacao;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kids.exception.KidsException;
import com.kids.model.Usuario;
import com.kids.moduloautenticacao.vo.UsuarioAtualizaVO;
import com.kids.moduloautenticacao.vo.UsuarioNovoVO;
import com.kids.util.KidsConstant;
import com.kids.util.KidsJsonUtil;
import com.kids.util.KidsRestUtil;
import com.kids.util.RestErroVo;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 05/2017
 * 
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioRestController {

    @Autowired
    private UsuarioService usuarioService;





    @CrossOrigin(origins = { KidsConstant.URL_WEB_DEV, KidsConstant.URL_WEB_PROD })
    @RequestMapping(method = GET, path = "/{email:.+}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserByEmail(@PathVariable(required = true) final String email) {

	final String[] accessControlAllowHeaders = new String[] {
	        "Accept, Accept-CH, Accept-Charset, Accept-Datetime, Accept-Encoding, Accept-Ext, Accept-Features, Accept-Language, Accept-Params, Accept-Ranges, Access-Control-Allow-Credentials, Access-Control-Allow-Headers, Access-Control-Allow-Methods, Access-Control-Allow-Origin, Access-Control-Expose-Headers, Access-Control-Max-Age, Access-Control-Request-Headers, Access-Control-Request-Method, Age, Allow, Alternates, Authentication-Info, Authorization, C-Ext, C-Man, C-Opt, C-PEP, C-PEP-Info, CONNECT, Cache-Control, Compliance, Connection, Content-Base, Content-Disposition, Content-Encoding, Content-ID, Content-Language, Content-Length, Content-Location, Content-MD5, Content-Range, Content-Script-Type, Content-Security-Policy, Content-Style-Type, Content-Transfer-Encoding, Content-Type, Content-Version, Cookie, Cost, DAV, DELETE, DNT, DPR, Date, Default-Style, Delta-Base, Depth, Derived-From, Destination, Differential-ID, Digest, ETag, Expect, Expires, Ext, From, GET, GetProfile, HEAD, HTTP-date, Host, IM, If, If-Match, If-Modified-Since, If-None-Match, If-Range, If-Unmodified-Since, Keep-Alive, Label, Last-Event-ID, Last-Modified, Link, Location, Lock-Token, MIME-Version, Man, Max-Forwards, Media-Range, Message-ID, Meter, Negotiate, Non-Compliance, OPTION, OPTIONS, OWS, Opt, Optional, Ordering-Type, Origin, Overwrite, P3P, PEP, PICS-Label, POST, PUT, Pep-Info, Permanent, Position, Pragma, ProfileObject, Protocol, Protocol-Query, Protocol-Request, Proxy-Authenticate, Proxy-Authentication-Info, Proxy-Authorization, Proxy-Features, Proxy-Instruction, Public, RWS, Range, Referer, Refresh, Resolution-Hint, Resolver-Location, Retry-After, Safe, Sec-Websocket-Extensions, Sec-Websocket-Key, Sec-Websocket-Origin, Sec-Websocket-Protocol, Sec-Websocket-Version, Security-Scheme, Server, Set-Cookie, Set-Cookie2, SetProfile, SoapAction, Status, Status-URI, Strict-Transport-Security, SubOK, Subst, Surrogate-Capability, Surrogate-Control, TCN, TE, TRACE, Timeout, Title, Trailer, Transfer-Encoding, UA-Color, UA-Media, UA-Pixels, UA-Resolution, UA-Windowpixels, URI, Upgrade, User-Agent, Variant-Vary, Vary, Version, Via, Viewport-Width, WWW-Authenticate, Want-Digest, Warning, Width, X-Content-Duration, X-Content-Security-Policy, X-Content-Type-Options, X-CustomHeader, X-DNSPrefetch-Control, X-Forwarded-For, X-Forwarded-Port, X-Forwarded-Proto, X-Frame-Options, X-Modified, X-OTHER, X-PING, X-PINGOTHER, X-Powered-By, X-Requested-With" };//

	final List<HttpMethod> metodos = Arrays.asList(HttpMethod.GET, HttpMethod.OPTIONS);

	final HttpHeaders headers = new HttpHeaders();
	headers.setAccessControlAllowOrigin("*");
	headers.setAccessControlAllowHeaders(Arrays.asList(accessControlAllowHeaders));
	headers.setAccessControlAllowMethods(metodos);

	final Usuario usuario = this.usuarioService.getUserByEmail(email);

	final HttpStatus httpStatus = usuario == null ? HttpStatus.NO_CONTENT : HttpStatus.OK;
	return ResponseEntity.status(httpStatus)//
	        .headers(headers).body(KidsJsonUtil.convertToJson(usuario));//
    }





    @CrossOrigin(origins = { KidsConstant.URL_WEB_DEV, KidsConstant.URL_WEB_PROD })
    @RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@Valid @RequestBody(required = true) final UsuarioNovoVO usuario, final Errors errors) {
	try {
	    if (KidsRestUtil.existeErroNaRequisicao(errors)) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(KidsRestUtil.getErros(errors));
	    } else {
		this.usuarioService.saveUsuario(usuario);
		return ResponseEntity.status(CREATED).build();
	    }
	} catch (final KidsException e) {
	    return ResponseEntity.status(CONFLICT).body(new RestErroVo(e.getMessage()));
	}
    }





    @CrossOrigin(origins = { KidsConstant.URL_WEB_DEV, KidsConstant.URL_WEB_PROD })
    @RequestMapping(method = PUT, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@Valid @RequestBody(required = true) final UsuarioAtualizaVO usuario, final Errors errors) {
	try {
	    if (KidsRestUtil.existeErroNaRequisicao(errors)) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(KidsRestUtil.getErros(errors));
	    } else {
		this.usuarioService.updateUsuario(usuario);
		return ResponseEntity.status(OK).build();
	    }
	} catch (final KidsException e) {
	    return ResponseEntity.status(CONFLICT).body(new RestErroVo(e.getMessage()));
	}
    }

}