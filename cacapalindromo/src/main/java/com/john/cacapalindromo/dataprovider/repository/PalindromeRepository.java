package com.john.cacapalindromo.dataprovider.repository;

import com.john.cacapalindromo.dataprovider.repository.entity.PalindromeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author john
 */
@Repository
public interface PalindromeRepository extends JpaRepository<PalindromeEntity, Long> {

    boolean existsByWord(String word);

}