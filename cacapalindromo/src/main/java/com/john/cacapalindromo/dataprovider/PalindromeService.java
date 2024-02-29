package com.john.cacapalindromo.dataprovider;

import com.john.cacapalindromo.dataprovider.repository.PalindromeRepository;
import com.john.cacapalindromo.entrypoint.mapper.IPalindromeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author john
 */
@Service
public class PalindromeService {

    @Autowired
    private PalindromeRepository palindromeRepository;

    @Autowired
    private IPalindromeMapper palindromeMapper;

    public Palindrome save(Palindrome palindrome) {
        return palindromeMapper.toDomain(palindromeRepository.save(palindromeMapper.toEntity(palindrome)));
    }

    public List<Palindrome> findAll() {
        return palindromeRepository.findAll().stream().map(pEntity -> palindromeMapper.toDomain(pEntity)).toList();
    }

}