package com.example.app.gateways;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Slf4j
@Configuration
public class EnderecoConfiguration implements ErrorDecoder {


    @Override
    public Exception decode(String s, Response response) {
        Response.Body body = response.body();
        try {
            InputStream inputStream = body.asInputStream();
            String text = new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining("\n"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new RuntimeException(String.valueOf(response.status()));
    }


}
