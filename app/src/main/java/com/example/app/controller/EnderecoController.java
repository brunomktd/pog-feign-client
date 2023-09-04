package com.example.app.controller;

import com.example.app.model.Endereco;
import com.example.app.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    private final EnderecoService service;

    @Autowired
    public EnderecoController(EnderecoService service) {
        this.service = service;
    }

    @GetMapping
    public Endereco create(@RequestParam("cep") String cep) {
        return this.service.searchZipCode(cep);
    }
}
