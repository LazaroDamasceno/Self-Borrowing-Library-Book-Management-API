package com.api.v1.borrower.utils;

import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.domain.BorrowerRepository;
import com.api.v1.borrower.exceptions.BorrowerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class BorrowerFinderUtil {

    @Autowired
    private BorrowerRepository repository;

    public Mono<Borrower> find(String ssn) {
        return repository
                .findAll()
                .filter(e -> e.getSsn().equals(ssn)
                    && e.getUpdatedAt() == null
                )
                .singleOrEmpty()
                .switchIfEmpty(Mono.error(BorrowerNotFoundException::new));
    }

}
