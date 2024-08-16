package com.api.v1.book.services;

import com.api.v1.book.domain.BookRepository;
import com.api.v1.book.dtos.BookResponseDto;
import com.api.v1.book.mappers.BookDtoResponseMapper;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
class FindAllBooksServiceImpl implements FindAllBooksService {

    @Autowired
    private BookRepository repository;

    @Override
    public Flux<BookResponseDto> findAll() {
        return repository
            .findAll()
            .flatMap(b -> Flux.just(BookDtoResponseMapper.map(b)));
    }

    @Override
    public Flux<BookResponseDto> findByAuthor(@NotBlank String author) {
        return repository
                .findAll()
                .filter(e -> e.getAuthor().equals(author))
                .flatMap(b -> Flux.just(BookDtoResponseMapper.map(b)));
    }

    @Override
    public Flux<BookResponseDto> findByField(@NotBlank String field) {
        return repository
                .findAll()
                .filter(e -> e.getField().equals(field))
                .flatMap(b -> Flux.just(BookDtoResponseMapper.map(b)));
    }

    @Override
    public Flux<BookResponseDto> findByYear(int year) {
        return repository
                .findAll()
                .filter(e -> e.getPublishingYear() == year)
                .flatMap(b -> Flux.just(BookDtoResponseMapper.map(b)));
    }

    @Override
    public Flux<BookResponseDto> findByFieldAndYear(@NotBlank String field, int year) {
        return repository
                .findAll()
                .filter(e ->
                            e.getField().equals(field)
                            &&
                            e.getPublishingYear() == year
                )
                .flatMap(b -> Flux.just(BookDtoResponseMapper.map(b)));
    }

    @Override
    public Flux<BookResponseDto> findByAuthorAndField(@NotBlank String author, @NotBlank String field) {
        return repository
                .findAll()
                .filter(e ->
                            e.getAuthor().equals(author)
                            &&
                            e.getField().equals(field)
                )
                .flatMap(b -> Flux.just(BookDtoResponseMapper.map(b)));
    }

    @Override
    public Flux<BookResponseDto> find(@NotBlank String author, @NotBlank String field, int year) {
        return repository
                .findAll()
                .filter(e ->
                            e.getAuthor().equals(author)
                            &&
                            e.getField().equals(field)
                            &&
                            e.getPublishingYear() == year
                )
                .flatMap(b -> Flux.just(BookDtoResponseMapper.map(b)));
    }

}