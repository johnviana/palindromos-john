package com.john.cacapalindromo.entrypoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/api/palindromos")
public class PalindromoController {

    private final BuscadorPalindromosUseCase buscadorPalindromosUseCase;

    @Autowired
    public PalindromoController(BuscadorPalindromosUseCase buscadorPalindromosUseCase) {
        this.buscadorPalindromosUseCase = buscadorPalindromosUseCase;
    }

    @PostMapping("")
    public ResponseEntity<?> buscarPalindromos(@RequestBody char[][] matriz) {
        try {
            // Encontra os palíndromos na matriz
            var palindromosEncontrados = buscadorPalindromosUseCase.buscarPalindromos(matriz);
            
            // Retorna os dados persistidos no banco de dados
            return ResponseEntity.ok(palindromosEncontrados);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}