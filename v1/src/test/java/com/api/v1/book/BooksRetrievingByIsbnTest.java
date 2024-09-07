package com.api.v1.book;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BooksRetrievingByIsbnTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    @Order(1)
    void testSuccessfulBookRetrieving() {
        String isbn = "123456789012";
        webTestClient
                .get()
                .uri("api/v1/books/by-isbn/%s".formatted(isbn))
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test
    @Order(2)
    void testUnsuccessfulBookRetrieving() {
        String isbn = "123456789011";
        webTestClient
                .get()
                .uri("api/v1/books/by-isbn/%s".formatted(isbn))
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

}
