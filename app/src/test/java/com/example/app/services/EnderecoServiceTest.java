package com.example.app.services;

import com.example.app.gateways.EnderecoClient;
import com.example.app.model.Endereco;
import com.example.app.repository.EnderecoRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.fail;

public class EnderecoServiceTest {
    public EnderecoService service;

    @Mock
    private EnderecoRepository repository;
    @Mock
    private EnderecoClient client;

    @Before
    public void onBefore() {
        MockitoAnnotations.openMocks(this);
        service = new EnderecoService(repository, client);
    }

    @Test
    public void searchZipCode() {
        // cenário
        String cep = "06422100";
        Endereco enderecoMock = new Endereco();
        enderecoMock.setId(1L);
        enderecoMock.setCep("06422100");

        Mockito.when(service.searchZipCode(Mockito.any())).thenReturn(enderecoMock);

        // ação
        Endereco endereco = service.searchZipCode(cep);


        // verificação
        Assert.assertEquals(Long.valueOf(1), endereco.getId());

    }

    @Test
    public void searchZipCodeWithError() {
        // cenário
        String cep = "cachorro";

        try {
            Endereco endereco = service.searchZipCode(cep);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}