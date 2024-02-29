package com.john.cacapalindromo.core.usecase.impl;

import com.john.cacapalindromo.core.domain.Palindromo;
import com.john.cacapalindromo.core.usecase.BuscadorPalindromosUseCase;

import java.util.ArrayList;
import java.util.List;
/**
 * @author john
 */
public class BuscadorPalindromosUseCaseImpl implements BuscadorPalindromosUseCase {

    @Override
    public List<Palindromo> buscarPalindromos(char[][] matriz) {
        List<Palindromo> palindromosEncontrados = new ArrayList<>();

        // Busca horizontal
        for (int i = 0; i < matriz.length; i++) {
            StringBuilder linha = new StringBuilder();
            for (int j = 0; j < matriz[i].length; j++) {
                linha.append(matriz[i][j]);
            }
            verificarPalindromo(linha.toString(), palindromosEncontrados);
        }

        // Busca vertical
        for (int i = 0; i < matriz[0].length; i++) {
            StringBuilder coluna = new StringBuilder();
            for (int j = 0; j < matriz.length; j++) {
                coluna.append(matriz[j][i]);
            }
            verificarPalindromo(coluna.toString(), palindromosEncontrados);
        }

        // Busca diagonais principais
        for (int i = 0; i < matriz.length; i++) {
            StringBuilder diagonal = new StringBuilder();
            for (int j = 0; j < matriz.length - i; j++) {
                diagonal.append(matriz[j][j + i]);
            }
            verificarPalindromo(diagonal.toString(), palindromosEncontrados);
        }

        for (int i = 1; i < matriz[0].length; i++) {
            StringBuilder diagonal = new StringBuilder();
            for (int j = 0; j < matriz[0].length - i; j++) {
                diagonal.append(matriz[j + i][j]);
            }
            verificarPalindromo(diagonal.toString(), palindromosEncontrados);
        }

        // Busca diagonais secundárias
        for (int i = 0; i < matriz.length; i++) {
            StringBuilder diagonal = new StringBuilder();
            for (int j = 0; j <= i; j++) {
                diagonal.append(matriz[j][i - j]);
            }
            verificarPalindromo(diagonal.toString(), palindromosEncontrados);
        }

        for (int i = 1; i < matriz.length; i++) {
            StringBuilder diagonal = new StringBuilder();
            for (int j = matriz.length - 1; j >= i; j--) {
                diagonal.append(matriz[j][matriz.length - j + i - 1]);
            }
            verificarPalindromo(diagonal.toString(), palindromosEncontrados);
        }

        return palindromosEncontrados;
    }

    private void verificarPalindromo(String palavra, List<Palindromo> palindromosEncontrados) {
        if (ehPalindromo(palavra)) {
            palindromosEncontrados.add(new Palindromo(palavra));
        }
    }

    private boolean ehPalindromo(String palavra) {
        int inicio = 0;
        int fim = palavra.length() - 1;
        while (inicio < fim) {
            if (palavra.charAt(inicio) != palavra.charAt(fim)) {
                return false;
            }
            inicio++;
            fim--;
        }
        return true;
    }
}