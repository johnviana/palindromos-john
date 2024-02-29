package com.john.cacapalindromo.core.usecase;

import com.john.cacapalindromo.core.domain.Palindromo;

import java.util.List;

public interface BuscadorPalindromosUseCase {
    List<Palindromo> buscarPalindromos(char[][] matriz);
}
