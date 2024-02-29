package com.john.cacapalindromo.entrypoint.controller.impl;

import com.john.cacapalindromo.core.usecase.IPalindromeUseCase;
import com.john.cacapalindromo.entrypoint.controller.IPalindromeController;
import com.john.cacapalindromo.entrypoint.mapper.IPalindromeMapper;
import com.john.cacapalindromo.entrypoint.response.PalindromeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/api/palindromes", produces = MediaType.APPLICATION_JSON_VALUE)
public class PalindromeController implements IPalindromeController {

    @Autowired
    private IPalindromeUseCase palindromeUseCase;

    @Autowired
    private IPalindromeMapper palindromeMapper;

    @Override
    @PostMapping
    public List<String> findAndSavePalindromes(@RequestBody char[][] headquarters) {
        return palindromeUseCase.findAndSavePalindromes(headquarters);
    }

    @Override
    @GetMapping
    public List<PalindromeResponse> searchPalindromes() {
        return palindromeUseCase.searchPalindromes().stream().map(p -> palindromeMapper.toResponse(p)).toList();
    }

}
