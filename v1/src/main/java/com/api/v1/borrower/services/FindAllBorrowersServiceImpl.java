package com.api.v1.borrower.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.domain.BorrowerRepository;
import com.api.v1.borrower.dtos.BorrowerResponse;
import com.api.v1.borrower.mapper.BorrowerMapper;

import reactor.core.publisher.Flux;

@Service
class FindAllBorrowersServiceImpl implements FindAllBorrowersService {

    @Autowired
    private BorrowerRepository repository;

    @Override
    public Flux<BorrowerResponse> findAll() {
        Flux<Borrower> borrowers = repository.findAll();
        return BorrowerMapper.mapFromFlux(borrowers);
    }
    
}