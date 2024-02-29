package com.john.cacapalindromo.dataprovider;

import com.john.cacapalindromo.core.domain.Palindromo;
import com.john.cacapalindromo.dataprovider.repository.PalindromeRepository;
import com.john.cacapalindromo.entrypoint.mapper.IPalindromeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author john
 */
@Service
public class PalindromeService {

    @Autowired
    private PalindromeRepository palindromeRepository;

    @Autowired
    private IPalindromeMapper palindromeMapper;

    public Palindromo save(Palindromo palindrome) {
        return palindromeMapper.toDomain(palindromeRepository.save(palindromeMapper.toEntity(palindrome)));
    }

    public List<Palindromo> findAll() {
        return palindromeRepository.findAll().stream().map(pEntity -> palindromeMapper.toDomain(pEntity)).toList();
    }

}