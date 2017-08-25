package com.kids.enumeration;

import com.kids.util.KidsMessageUtil;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 08/2017
 *
 */
public enum DiarioTipo {

    REFEICAO_CAFE_MANHA("com.kids.enumeration.DiarioTipo_REFEICAO_CAFE_MANHA"), //
    REFEICAO_ALMOCO("com.kids.enumeration.DiarioTipo_REFEICAO_ALMOCO"), //
    REFEICAO_CAFE_TARDE("com.kids.enumeration.DiarioTipo_REFEICAO_CAFE_TARDE"), //
    REFEICAO_JANTA("com.kids.enumeration.DiarioTipo_REFEICAO_JANTA"), // 
    EVACUACAO("com.kids.enumeration.DiarioTipo_EVACUACAO"), //
    SONO("com.kids.enumeration.DiarioTipo_SONO");

    private String tipo;





    private DiarioTipo(final String tipo) {
	this.tipo = tipo;
    }





    public String getTipo() {
	return KidsMessageUtil.getMessage(this.tipo);
    }
}