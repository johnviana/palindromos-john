package com.john.cacapalindromo.config;

import com.john.cacapalindromo.core.usecase.impl.PalindromeUseCaseImpl;
import com.john.cacapalindromo.dataprovider.PalindromeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PalindromeConfig {

    @Bean
    public PalindromeUseCaseImpl palindromeUseCase(PalindromeService palindromeService) {
        return new PalindromeUseCaseImpl(palindromeService);
    }

}