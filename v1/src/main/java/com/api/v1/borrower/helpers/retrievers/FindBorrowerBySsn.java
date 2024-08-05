package com.api.v1.borrower.helpers.retrievers;

import com.api.v1.borrower.domain.Borrower;

import reactor.core.publisher.Mono;

public interface FindBorrowerBySsn {

    Mono<Borrower> findBySsn(String ssn);

}