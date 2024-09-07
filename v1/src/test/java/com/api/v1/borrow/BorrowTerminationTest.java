package com.api.v1.borrow;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BorrowTerminationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testSuccessfulBorrowTermination() {
        String id = "2024001";
        String endpoint = "api/v1/borrows/%s/termination".formatted(id);
        webTestClient
                .patch()
                .uri(endpoint)
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test
    void testUnsuccessfulBorrowTermination() {
        String id = "2024001";
        String endpoint = "api/v1/borrows/%s/termination".formatted(id);
        webTestClient
                .patch()
                .uri(endpoint)
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

}
