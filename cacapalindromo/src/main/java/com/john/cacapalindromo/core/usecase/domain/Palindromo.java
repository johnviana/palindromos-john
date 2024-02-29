package com.john.cacapalindromo.core.usecase.domain;

/**
 * @author john
 */
public class Palindromo {

    private Long palindromeId;
    private String word;

    public Palindromo() {
    }

    public Palindromo(Long palindromeId, String word) {
        this.palindromeId = palindromeId;
        this.word = word;
    }

    public Long getPalindromoId() {
        return palindromeId;
    }

    public void setPalindromeId(Long palindromeId) {
        this.palindromeId = palindromeId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "Palindromo{" +
                "palindromeId=" + palindromeId +
                ", word='" + word + '\'' +
                '}';
    }

}