package com.api.v1.book_borrow.find_by_borrower.finished;

import com.api.v1.book_borrow.BookBorrow;
import com.api.v1.customized_annotations.SSN;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("api/v1/book-borrows")
public class FindFinishedBookBorrowsByBorrowerController {

    private final FindFinishedBookBorrowsByBorrowerService service;

    public FindFinishedBookBorrowsByBorrowerController(FindFinishedBookBorrowsByBorrowerService service) {
        this.service = service;
    }

    @GetMapping("finished/by-ssn/{ssn}")
    @Async
    public CompletableFuture<List<BookBorrow>> findFinishedByBorrower(@SSN @PathVariable String ssn) {
        return service.findFinishedByBorrower(ssn);
    }

}
