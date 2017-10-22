package com.kids.modulogaleria.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.kids.modulogaleria.vo.GaleriaVO;

public class CriaArquivoDaFoto {

    final File diretorio = new File("src/main/resources/img/creche/");

    private Map<GaleriaVO, File> galeriasComArquivo = new HashMap<>();





    public void agrupar(final GaleriaVO galeriaVO) {
	final File arquivo = new File(diretorio, galeriaVO.getImagem());
	this.galeriasComArquivo.put(galeriaVO, arquivo);
    }





    public File getArquivo(final GaleriaVO galeriaVO) {
	return this.galeriasComArquivo.get(galeriaVO);
    }

}