package com.john.cacapalindromo.dataprovider;

import com.john.cacapalindromo.core.usecase.domain.Palindromo;
import com.john.cacapalindromo.dataprovider.repository.PalindromeRepository;
import com.john.cacapalindromo.dataprovider.repository.entity.PalindromeEntity;
import com.john.cacapalindromo.entrypoint.mapper.IPalindromeMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeServiceTest {

    @Mock
    private PalindromeRepository palindromeRepository;

    @Mock
    private IPalindromeMapper palindromeMapper;

    @InjectMocks
    private PalindromeService palindromeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void save_Success() {

        Palindromo inputPalindrome = new Palindromo();
        inputPalindrome.setWord("radar");
        PalindromeEntity mappedEntity = new PalindromeEntity();
        Mockito.when(palindromeMapper.toEntity(inputPalindrome)).thenReturn(mappedEntity);
        Mockito.when(palindromeRepository.save(mappedEntity)).thenReturn(mappedEntity);
        Mockito.when(palindromeMapper.toDomain(mappedEntity)).thenReturn(inputPalindrome);

        Palindromo savedPalindrome = palindromeService.save(inputPalindrome);

        assertNotNull(savedPalindrome);
        assertEquals(inputPalindrome.getWord(), savedPalindrome.getWord());

    }

    @Test
    void save_Failure() {

        Palindromo inputPalindrome = new Palindromo();
        PalindromeEntity mappedEntity = new PalindromeEntity();
        Mockito.when(palindromeMapper.toEntity(inputPalindrome)).thenReturn(mappedEntity);

        Mockito.when(palindromeRepository.save(mappedEntity)).thenThrow(new RuntimeException("Erro ao salvar o palíndromo"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            palindromeService.save(inputPalindrome);
        });

        assertNotNull(exception);
        assertEquals("Erro ao salvar o palíndromo", exception.getMessage());
    }

    @Test
    void findAll_Success() {

}
    @Test
    void findAll_Failure() {

    }
}