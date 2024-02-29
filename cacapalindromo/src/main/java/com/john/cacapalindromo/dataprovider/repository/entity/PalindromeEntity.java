package com.john.cacapalindromo.dataprovider.repository.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * @author john
 */
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "palindrome")
public class PalindromeEntity {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long palindromeId;

    @Column(name = "word")
    private String word;

}
