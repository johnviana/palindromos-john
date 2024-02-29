package com.john.cacapalindromo.dataprovider;

import com.john.cacapalindromo.core.dataprovider.PalindromoDataProvider;
import com.john.cacapalindromo.core.domain.Palindromo;
import com.john.cacapalindromo.dataprovider.repository.PalindromoRepository;
import com.john.cacapalindromo.dataprovider.repository.entity.PalindromoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PalindromoDataProviderImpl implements PalindromoDataProvider {

    private final PalindromoRepository palindromoRepository;

    @Autowired
    public PalindromoDataProviderImpl(PalindromoRepository palindromoRepository) {
        this.palindromoRepository = palindromoRepository;
    }

    @Override
    public void salvarPalindromos(List<Palindromo> palindromos) {
        Set<String> palindromosUnicos = new HashSet<>();
        for (Palindromo palindromo : palindromos) {
            palindromosUnicos.add(palindromo.getPalavra());
        }

        List<PalindromoEntity> entities = palindromosUnicos.stream()
                .map(palavra -> new PalindromoEntity(palavra))
                .collect(Collectors.toList());
        palindromoRepository.saveAll(entities);
    }
}
