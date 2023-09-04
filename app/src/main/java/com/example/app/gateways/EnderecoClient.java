package com.example.app.gateways;


import com.example.app.model.Endereco;
import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "endereco", url = "viacep.com.br", configuration = EnderecoConfiguration.class)
public interface EnderecoClient {

    @GetMapping( value = "/ws/{cep}/json/", consumes = "application/json")
    Endereco searchZipCode(@PathVariable("cep") String cep);
}
