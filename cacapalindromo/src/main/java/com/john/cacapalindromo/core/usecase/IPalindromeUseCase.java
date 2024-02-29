package com.john.cacapalindromo.core.usecase;

import com.john.cacapalindromo.core.usecase.domain.Palindromo;

import java.util.List;
/**
 * @author john
 */
public interface IPalindromeUseCase {

    List<String> findAndSavePalindromes(char[][] headquarters);

    List<Palindromo> searchPalindromes();

}
