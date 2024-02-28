package com.john.cacapalindromo.core.domain;

/**
 * @author john
 */
public class Palindrome {

    private String id;

    private String polindrome;

    public Palindrome(){}

    public Palindrome(String id, String polindrome) {
        this.id = id;
        this.polindrome = polindrome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPolindrome() {
        return polindrome;
    }

    public void setPolindrome(String polindrome) {
        this.polindrome = polindrome;
    }
}
