package com.kids.modulocrianca;

import java.util.HashMap;
import java.util.Map;

import com.kids.modulocrianca.vo.AlergiaVO;

public class ValidaAlergiaAdicionada {

	private Map<Integer, String> alergias = new HashMap<>();

	private int count = 0;



	public void validar(final AlergiaVO alergia) throws AlergiaDuplicadaException {
		if (this.alergias.containsValue(alergia.getDescricao().trim())) {
			throw new AlergiaDuplicadaException(alergia.getDescricao().trim());
		} else {
			this.alergias.put(count, alergia.getDescricao().trim());
		}
		count++;
	}
}