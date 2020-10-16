package com.ic.sandbox.simpleapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@SpringBootApplication
public class SimpleAppApplication {

    public static void main(String... args) {
        SpringApplication.run(SimpleAppApplication.class, args);
    }

    private static HandlerFunction<ServerResponse> indexFct = serverRequest -> ok().contentType(MediaType.TEXT_HTML).bodyValue("It works!");

    @Bean
    public RouterFunction<ServerResponse> router(){
        return RouterFunctions.route(GET("/"), indexFct)
                .andRoute(GET("/index.htm"), indexFct)
                .andRoute(GET("/index"), indexFct);
    }
}
