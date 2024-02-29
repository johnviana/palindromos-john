package com.john.cacapalindromo.core.domain;

/**
 * @author john
 */
public class Palindromo {

    private Long idPalindromo;
    private String palavra;

    public Palindromo() {
    }

    public Palindromo(Long idPalindromo, String palavra) {
        this.idPalindromo = idPalindromo;
        this.palavra = palavra;
    }

    public Long getIdPalindromo() {
        return idPalindromo;
    }

    public void setIdPalindromo(Long idPalindromo) {
        this.idPalindromo = idPalindromo;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    @Override
    public String toString() {
        return "Palindromo{" +
                "idPalindromo=" + idPalindromo +
                ", palavra='" + palavra + '\'' +
                '}';
    }
}