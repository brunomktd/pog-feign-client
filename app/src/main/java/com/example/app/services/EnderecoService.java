package com.example.app.services;

import com.example.app.gateways.EnderecoClient;
import com.example.app.model.Endereco;
import com.example.app.repository.EnderecoRepository;
import feign.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Reader;

@Slf4j
@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository repository;
    private final EnderecoClient client;

    public Endereco createEndereco(String cep) {
        Endereco endereco = this.searchZipCode(cep);
        return repository.save(endereco);
    }

    public Endereco searchZipCode(String cep) {

        Endereco response = this.client.searchZipCode(cep);


        return null;
    }
}
