package com.api.v1.book_borrow.find_by_borrower.all;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.book_borrow.BookBorrow;
import com.api.v1.customized_annotations.SSN;

@RestController
@RequestMapping("api/v1/book-borrows")
public class FindAllBorrowsByBorrowerController {
    
    private final FindAllBorrowsByBorrowerService service;

    public FindAllBorrowsByBorrowerController(FindAllBorrowsByBorrowerService service) {
        this.service = service;
    }

    @GetMapping("by-ssn/{ssn}")
    @Async
    public CompletableFuture<List<BookBorrow>> findAllBorrowsByBorrower(@SSN @PathVariable String ssn) {
        return service.findAllBorrowsByBorrower(ssn);
    }

}
