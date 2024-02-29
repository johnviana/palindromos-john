package com.john.cacapalindromo.core.dataprovider;

import com.john.cacapalindromo.core.domain.Palindromo;

import java.util.List;

public interface PalindromoDataProvider {

    void salvarPalindromos(List<Palindromo> palindromos);

}