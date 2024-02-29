package com.john.cacapalindromo.dataprovider;

import com.john.cacapalindromo.core.exception.PalindromeServiceException;
import com.john.cacapalindromo.core.usecase.domain.Palindromo;
import com.john.cacapalindromo.dataprovider.repository.PalindromeRepository;
import com.john.cacapalindromo.dataprovider.repository.entity.PalindromeEntity;
import com.john.cacapalindromo.entrypoint.mapper.IPalindromeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author john
 */
@Service
public class PalindromeService {
    private static final Logger logger = LoggerFactory.getLogger(PalindromeService.class);

    private final PalindromeRepository palindromeRepository;
    private final IPalindromeMapper palindromeMapper;

    public PalindromeService(PalindromeRepository palindromeRepository, IPalindromeMapper palindromeMapper) {
        this.palindromeRepository = palindromeRepository;
        this.palindromeMapper = palindromeMapper;
    }

    public Palindromo save(Palindromo palindrome) {
        try {
            PalindromeEntity entity = palindromeMapper.toEntity(palindrome);
            PalindromeEntity savedEntity = palindromeRepository.save(entity);
            return palindromeMapper.toDomain(savedEntity);
        } catch (Exception e) {
            logger.error("Erro ao salvar o palíndromo", e);
            throw new PalindromeServiceException("Erro ao salvar o palíndromo", e);
        }
    }

    public List<Palindromo> findAll() {
        try {
            List<PalindromeEntity> entities = palindromeRepository.findAll();
            return entities.stream()
                    .map(palindromeMapper::toDomain)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            logger.error("Erro ao buscar os palíndromos", e);
            throw new PalindromeServiceException("Erro ao buscar os palíndromos", e);
        }
    }
}