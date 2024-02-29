package com.john.cacapalindromo.config;

import com.john.cacapalindromo.core.dataprovider.PalindromoDataProvider;
import com.john.cacapalindromo.core.usecase.impl.BuscadorPalindromosUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    private final PalindromoDataProvider palindromoDataProvider;

    public AppConfig(PalindromoDataProvider palindromoDataProvider) {
        this.palindromoDataProvider = palindromoDataProvider;
    }

    @Bean
    public BuscadorPalindromosUseCase buscadorPalindromosUseCase() {
        return new BuscadorPalindromosUseCaseImpl(palindromoDataProvider);
    }
}