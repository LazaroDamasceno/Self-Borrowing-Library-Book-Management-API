package com.api.v1.book.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.book.services.DeleteBookByIsbnService;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/books")
class DeleteBookByIsbnController {

    @Autowired
    private DeleteBookByIsbnService service;

    @DeleteMapping("{isbn}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteByIsbn(@NotNull @Size(min=13, max=13) @PathVariable String isbn) {
        return service.deleteByIsbn(isbn);
    }
    
}
