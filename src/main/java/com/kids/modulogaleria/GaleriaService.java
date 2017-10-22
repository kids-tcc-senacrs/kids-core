package com.kids.modulogaleria;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kids.enumeration.TipoUsuario;
import com.kids.exception.KidsException;
import com.kids.model.Creche;
import com.kids.model.Galeria;
import com.kids.model.Usuario;
import com.kids.moduloautenticacao.UsuarioFacade;
import com.kids.moduloautenticacao.validate.UsuarioInexistenteException;
import com.kids.modulocreche.CrecheFacade;
import com.kids.modulofamilia.FamiliaService;
import com.kids.modulogaleria.util.CriaArquivoDaFoto;
import com.kids.modulogaleria.vo.GaleriaVO;
import com.kids.repository.GaleriaRepository;

@Service
public class GaleriaService {

    @Autowired
    private GaleriaRepository galeriaRepository;

    @Autowired
    private CrecheFacade crecheFacade;

    @Autowired
    private UsuarioFacade usuarioFacade;

    @Autowired
    private FamiliaService familiaService;

    final static Logger LOGGER = Logger.getLogger(GaleriaService.class);





    public void save(final MultipartFile file, final String fileName) throws KidsException {

	final Long crecheId = Long.valueOf(fileName.split("param___descricao")[0]);
	final String descricao = fileName.split("param___descricao")[1].toString().split("param_tipo")[0].toString();
	final String tipo = fileName.split("param_tipo")[1].toString().split("/")[1];

	this.validarTipoArquivo(tipo);

	final Creche creche = this.crecheFacade.buscarCreche(crecheId);

	final Galeria galeria = new Galeria();
	galeria.setCreche(creche);
	galeria.setDescricao(descricao);
	galeria.setDtPost(LocalDateTime.now());
	this.galeriaRepository.persist(galeria);

	try {
	    final File diretorio = new File("src/main/resources/img/creche/");
	    final String nomeArquivo = new StringBuilder().append(galeria.getCreche().getId()).append(galeria.getId()).append(".").append(tipo).toString();
	    final String pathCompletoImagem = Paths.get(diretorio.getPath(), nomeArquivo).toString();
	    final BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(pathCompletoImagem)));
	    bos.write(file.getBytes());
	    bos.close();

	    this.atualizarGaleria(nomeArquivo, galeria);

	    LOGGER.info("UPLOAD REALIZADO COM SUCESSO");

	} catch (final Exception e) {
	    LOGGER.info("ERRO AO REALIZAR UPLOAD DE IMAGENS VIA GALERIA", e);
	    throw new KidsException("Ocorreu um erro inesperado!!!");
	}

    }





    private void atualizarGaleria(final String nomeArquivo, final Galeria galeria) {
	galeria.setImagem(nomeArquivo);
	this.galeriaRepository.update(galeria);
    }





    private void validarTipoArquivo(final String tipo) throws TipoImagemInvalidaException {
	final List<String> tiposAceitos = Arrays.asList("jpeg", "jpg", "png");
	if (!tiposAceitos.contains(tipo)) {
	    throw new TipoImagemInvalidaException();
	}
    }





    public List<GaleriaVO> getGaleriasByUsuarioId(final Long usuarioId) throws UsuarioInexistenteException {

	List<GaleriaVO> galerias = new ArrayList<>();

	final Usuario usuario = this.usuarioFacade.buscarUsuarioById(usuarioId);

	if (TipoUsuario.CRECHE.equals(usuario.getTipo())) {

	    final Creche creche = this.crecheFacade.getCrecheByUsuario(usuario);
	    galerias = this.galeriaRepository.findGaleriasByCrecheId(creche.getId());

	} else if (TipoUsuario.FAMILIAR.equals(usuario.getTipo())) {

	    final Set<Long> crechesIds = this.getCrechesIds(this.familiaService.findCrechesByUsuarioFamiliar(usuario));
	    for (final Long crecheId : crechesIds) {
		galerias = this.galeriaRepository.findGaleriasByCrecheId(crecheId);
	    }

	}

	final CriaArquivoDaFoto criaArquivoDaFoto = new CriaArquivoDaFoto();
	for (final GaleriaVO galeriaVO : galerias) {
	    criaArquivoDaFoto.agrupar(galeriaVO);
	}
	for (final GaleriaVO galeriaVO : galerias) {
	    final File imagem = criaArquivoDaFoto.getArquivo(galeriaVO);
	    final String imagemBase64 = this.convertToBase64(imagem);
	    galeriaVO.setImagem(imagemBase64);
	}

	return galerias;
    }





    final Set<Long> getCrechesIds(final List<Creche> creches) {
	final Set<Long> naoAguentoMaisCodarEsseTcc = new HashSet<Long>();
	if (CollectionUtils.isNotEmpty(creches)) {
	    for (final Creche creche : creches) {
		naoAguentoMaisCodarEsseTcc.add(creche.getId());
	    }
	}
	return naoAguentoMaisCodarEsseTcc;
    }





    private String convertToBase64(final File imagem) {
	try {
	    final byte[] fileContent = FileUtils.readFileToByteArray(imagem);
	    final byte[] base64 = Base64.encodeBase64(fileContent, false);
	    return StringUtils.newStringUtf8(base64);
	} catch (Exception e) {
	    LOGGER.error("erro");
	}
	return null;
    }

}