package com.john.cacapalindromo.dataprovider.repository;

import com.john.cacapalindromo.dataprovider.repository.entity.PalindromoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PalindromoRepository extends JpaRepository<PalindromoEntity, Long> {
}