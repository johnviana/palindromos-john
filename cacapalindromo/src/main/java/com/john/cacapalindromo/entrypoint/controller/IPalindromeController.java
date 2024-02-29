package com.john.cacapalindromo.entrypoint.controller;

import com.john.cacapalindromo.entrypoint.response.PalindromeResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Palindromes")
public interface IPalindromeController {

    @Operation(summary = "Encontre todos os palíndromos existentes na matriz, considerando as posições horizontal, vertical e diagonal (qualquer direção).",
            method = "POST")
    List<String> findAndSavePalindromes(@RequestBody char[][] headquarters);

    @Operation(summary = "Buscar palíndromos salvos", method = "GET")
    List<PalindromeResponse> searchPalindromes();

}