package com.api.v1.book.controllers;

import com.api.v1.annotations.ISBN;
import com.api.v1.book.dtos.BookResponseDto;
import com.api.v1.book.services.FindAllBooksService;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/books")
public class FindAllBooksController {

    @Autowired
    private FindAllBooksService service;

    @GetMapping("by-isbn/{isbn}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<BookResponseDto> findBookByIsbn(@ISBN @PathVariable String isbn) {
        return service.findBookByIsbn(isbn);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BookResponseDto> findAll() {
        return service.findAll();
    }

    @GetMapping("by-author/{author}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BookResponseDto> findByAuthor(@NotBlank @PathVariable String author) {
        return service.findByAuthor(author);
    }

    @GetMapping("by-filed/{field}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BookResponseDto> findByField(@NotBlank @PathVariable String field) {
        return service.findByField(field);
    }

    @GetMapping("by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BookResponseDto> findByYear(@PathVariable int year) {
        return service.findByYear(year);
    }

    @GetMapping("by-filed/{field}/and/by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BookResponseDto> findByFieldAndYear(@NotBlank @PathVariable String field, @PathVariable int year) {
        return service.findByFieldAndYear(field, year);
    }

    @GetMapping("by-author/{author}/and/by-field/{field}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BookResponseDto> findByAuthorAndField(@NotBlank @PathVariable String author,
                                                      @NotBlank @PathVariable String field
    ) {
        return service.findByAuthorAndField(author, field);
    }

    @GetMapping("by-author/{author}/and/by-field/{field}/and/by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BookResponseDto> find(
            @NotBlank @PathVariable String author,
            @NotBlank @PathVariable String field,
            @PathVariable int year
    ) {
        return service.find(author, field, year);
    }

}
