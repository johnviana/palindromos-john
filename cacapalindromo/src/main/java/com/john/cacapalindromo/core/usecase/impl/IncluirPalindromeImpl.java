package com.john.cacapalindromo.core.usecase.impl;

import com.john.cacapalindromo.core.dataprovider.IncluirPalindrome;
import com.john.cacapalindromo.core.domain.Palindrome;
import com.john.cacapalindromo.core.usecase.IncluirPalindromeUserCase;

public class IncluirPalindromeImpl implements IncluirPalindromeUserCase {

    private final IncluirPalindrome incluirPalindrome;

    public IncluirPalindromeImpl(IncluirPalindrome incluirPalindrome){
        this.incluirPalindrome = incluirPalindrome;
    }

    @Override
    public void incluir(Palindrome palindrome) {
        incluirPalindrome.incluir(palindrome);
    }
}
