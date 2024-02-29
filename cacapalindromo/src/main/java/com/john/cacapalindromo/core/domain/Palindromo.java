package com.john.cacapalindromo.core.domain;

/**
 * @author john
 */
public class Palindromo {

    private Long id;
    private String palavra;

    public Palindromo(String palavra) {
        this.palavra = palavra;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }
}

