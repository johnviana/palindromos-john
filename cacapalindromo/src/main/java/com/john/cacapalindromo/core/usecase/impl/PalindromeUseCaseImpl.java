package com.john.cacapalindromo.core.usecase.impl;

import com.john.cacapalindromo.core.domain.Palindromo;
import com.john.cacapalindromo.core.usecase.IPalindromeUseCase;
import com.john.cacapalindromo.dataprovider.PalindromeService;
import org.apache.coyote.BadRequestException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * @author john
 */
public class PalindromeUseCaseImpl implements IPalindromeUseCase {

    private final PalindromeService palindromeService;

    public PalindromeUseCaseImpl(PalindromeService palindromeService) {
        this.palindromeService = palindromeService;
    }

    @Override
    public List<String> findAndSavePalindromes(char[][] headquarters) {
        if (headquarters == null || headquarters.length == 0)
            throw new BadRequestException("Matriz de entrada inválida.");

        Set<String> palindromes = findPalindromesInHeadquarters(headquarters);

        List<String> response = new ArrayList<>();

        for (String word : palindromes) {
            if (checkIfIsPalindrome(word)) {
                saveNewPalindromeByWord(word);

                response.add(word);
            }
        }

        return response;
    }

    @Override
    public List<Palindromo> searchPalindromes() {
        return palindromeService.findAll();
    }

    private void saveNewPalindromeByWord(String word) {
        Palindromo palindrome = new Palindromo();
        palindrome.setWord(word);

        palindromeService.save(palindrome);
    }

    private Set<String> findPalindromesInHeadquarters(char[][] headquarters) {
        Set<String> palindromes = new HashSet<>();

        // horizontal and vertical
        for (int i = 0; i < headquarters.length; i++) {
            StringBuilder line = new StringBuilder();
            StringBuilder column = new StringBuilder();

            for (int j = 0; j < headquarters[i].length; j++) {
                line.append(headquarters[i][j]);
                column.append(headquarters[j][i]);
            }

            palindromes.addAll(findPalindromesInString(line.toString()));
            palindromes.addAll(findPalindromesInString(column.toString()));
        }

        // diagonal
        StringBuilder diagonal = new StringBuilder();
        for (int i = 0; i < headquarters.length; i++) {
            diagonal.append(headquarters[i][i]);
        }
        palindromes.addAll(findPalindromesInString(diagonal.toString()));

        return palindromes;
    }

    private Set<String> findPalindromesInString(String str) {
        Set<String> palindromes = new HashSet<>();

        int length = str.length();
        for (int i = 0; i < length; i++) {
            for (int j = i + 2; j <= length; j++)
                palindromes.add(str.substring(i, j));
        }

        return palindromes;
    }

    private boolean checkIfIsPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--))
                return false;
        }

        return true;
    }

}