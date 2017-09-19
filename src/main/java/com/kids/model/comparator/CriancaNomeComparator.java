package com.kids.model.comparator;

import java.util.Comparator;

import com.kids.model.Crianca;

public class CriancaNomeComparator implements Comparator<Crianca> {

    @Override
    public int compare(final Crianca o1, final Crianca o2) {
	return o1.getPessoa().getNome().compareTo(o2.getPessoa().getNome());
    }

}