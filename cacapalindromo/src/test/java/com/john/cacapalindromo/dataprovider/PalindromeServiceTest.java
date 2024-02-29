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

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author john
 */
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
        // Given
        PalindromeEntity entity1 = new PalindromeEntity();
        PalindromeEntity entity2 = new PalindromeEntity();
        List<PalindromeEntity> entityList = Arrays.asList(entity1, entity2);
        Mockito.when(palindromeRepository.findAll()).thenReturn(entityList);

        Palindromo domain1 = new Palindromo();
        Palindromo domain2 = new Palindromo();
        List<Palindromo> domainList = Arrays.asList(domain1, domain2);
        Mockito.when(palindromeMapper.toDomain(entity1)).thenReturn(domain1);
        Mockito.when(palindromeMapper.toDomain(entity2)).thenReturn(domain2);

        List<Palindromo> foundPalindromes = palindromeService.findAll();

        assertNotNull(foundPalindromes);
        assertEquals(2, foundPalindromes.size());
    }

    @Test
    void findAll_Failure() {
        Mockito.when(palindromeRepository.findAll()).thenThrow(new RuntimeException("Erro ao buscar os palíndromos"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            palindromeService.findAll();
        });

        assertTrue(exception.getMessage().contains("Erro ao buscar os palíndromos"));
    }
}