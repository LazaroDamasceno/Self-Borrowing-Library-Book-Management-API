package com.api.v1.borrow;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BorrowExtensionTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testSuccessfulBookExtension() {
        String id = "2024001";
        webTestClient
                .patch()
                .uri("api/v1/borrows/%s/extension".formatted(id))
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test
    void testUnsuccessfulBookExtension() {
        String id = "2024001";
        webTestClient
                .patch()
                .uri("api/v1/borrows/%s/extension".formatted(id))
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

}