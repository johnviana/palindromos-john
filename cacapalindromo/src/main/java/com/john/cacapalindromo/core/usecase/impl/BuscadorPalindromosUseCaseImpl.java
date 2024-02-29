package com.john.cacapalindromo.core.usecase.impl;

import com.john.cacapalindromo.core.dataprovider.PalindromoDataProvider;
import com.john.cacapalindromo.core.domain.Palindromo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author john
 */
public class BuscadorPalindromosUseCaseImpl implements BuscadorPalindromosUseCase {

    private final PalindromoDataProvider palindromoDataProvider;

    public BuscadorPalindromosUseCaseImpl(PalindromoDataProvider palindromoDataProvider) {
        this.palindromoDataProvider = palindromoDataProvider;
    }
    @Override
    public List<Palindromo> buscarPalindromos(char[][] matriz) {
        Set<String> palindromosEncontrados = new HashSet<>();

        // Verificar palíndromos na horizontal e vertical
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                verificarPalindromosNaPosicao(matriz, i, j, palindromosEncontrados);
            }
        }

        List<Palindromo> palindromosParaSalvar = criarListaDePalindromos(palindromosEncontrados);
        palindromoDataProvider.salvarPalindromos(palindromosParaSalvar);

        return criarListaDePalindromos(palindromosEncontrados);
    }

    private void verificarPalindromosNaPosicao(char[][] matriz, int linha, int coluna, Set<String> palindromosEncontrados) {
        int tamanho = matriz.length;
        StringBuilder palavra = new StringBuilder();

        // Horizontal (esquerda para direita)
        for (int i = coluna; i < tamanho; i++) {
            palavra.append(matriz[linha][i]);
            verificarEAdicionarPalindromo(palavra.toString(), palindromosEncontrados);
        }

        // Vertical (cima para baixo)
        palavra.setLength(0); // Limpar StringBuilder
        for (int i = linha; i < tamanho; i++) {
            palavra.append(matriz[i][coluna]);
            verificarEAdicionarPalindromo(palavra.toString(), palindromosEncontrados);
        }

        // Diagonal principal (superior esquerda para inferior direita)
        palavra.setLength(0); // Limpar StringBuilder
        for (int i = 0; linha + i < tamanho && coluna + i < tamanho; i++) {
            palavra.append(matriz[linha + i][coluna + i]);
            verificarEAdicionarPalindromo(palavra.toString(), palindromosEncontrados);
        }

        // Diagonal secundária (superior direita para inferior esquerda)
        palavra.setLength(0); // Limpar StringBuilder
        for (int i = 0; linha + i < tamanho && coluna - i >= 0; i++) {
            palavra.append(matriz[linha + i][coluna - i]);
            verificarEAdicionarPalindromo(palavra.toString(), palindromosEncontrados);
        }
    }

    private void verificarEAdicionarPalindromo(String palavra, Set<String> palindromosEncontrados) {
        if (ehPalindromo(palavra) && palavra.length() > 1) {
            palindromosEncontrados.add(palavra);
        }
    }

    private boolean ehPalindromo(String palavra) {
        int inicio = 0;
        int fim = palavra.length() - 1;
        while (inicio < fim) {
            if (palavra.charAt(inicio++) != palavra.charAt(fim--)) {
                return false;
            }
        }
        return true;
    }

    private List<Palindromo> criarListaDePalindromos(Set<String> palindromosEncontrados) {
        List<Palindromo> listaDePalindromos = new ArrayList<>();
        for (String palavra : palindromosEncontrados) {
            listaDePalindromos.add(new Palindromo(palavra));
        }
        return listaDePalindromos;
    }
}