package com.ic.sandbox.simpleapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@SpringBootApplication
public class SimpleAppApplication {

    public static void main(String... args) {
        SpringApplication.run(SimpleAppApplication.class, args);
    }

    private static HandlerFunction<ServerResponse> indexFct = serverRequest -> ok().contentType(MediaType.TEXT_HTML).bodyValue("It works!");

    private static HandlerFunction<ServerResponse> loadFct = serverRequest -> {
        final int NUM_TESTS = 1000;
        for (int i = 0; i < NUM_TESTS; i++) {
            long sleepTime = 250*1000000L; // convert to nanoseconds
            long startTime = System.nanoTime();
            while ((System.nanoTime() - startTime) < sleepTime) {}
        }
        return ok().contentType(MediaType.TEXT_HTML).bodyValue("Load Test Done!");
    };

    @Bean
    public RouterFunction<ServerResponse> router(){
        return RouterFunctions.route(GET("/"), indexFct)
                .andRoute(GET("/index.htm"), indexFct)
                .andRoute(GET("/index"), indexFct)
                .andRoute(GET("/load"), loadFct);
    }
}
