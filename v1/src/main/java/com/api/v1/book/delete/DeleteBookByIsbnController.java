package com.api.v1.book.delete;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/books")
public class DeleteBookByIsbnController {
    
    private final DeleteBookByIsbnService service;

    public DeleteBookByIsbnController(DeleteBookByIsbnService service) {
        this.service = service;
    }

    @DeleteMapping("{isbn}")
    public ResponseEntity<Void> delete(String isbn) {
        service.delete(isbn);
        return ResponseEntity.status(204).build();
    }

}
