package com.api.v1.borrow.services;

import com.api.v1.annotations.ISBN;
import com.api.v1.annotations.SSN;
import com.api.v1.book.utils.BookFinderUtil;
import com.api.v1.borrow.builders.BorrowBuilder;
import com.api.v1.borrow.domain.Borrow;
import com.api.v1.borrow.domain.BorrowRepository;
import com.api.v1.borrow.dtos.BorrowResponseDto;
import com.api.v1.borrow.mappers.BorrowResponseMapper;
import com.api.v1.borrower.utils.BorrowerFinderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class BorrowingServiceImpl implements BorrowingService {

    @Autowired
    private BorrowerFinderUtil borrowerFinderUtil;

    @Autowired
    private BookFinderUtil bookFinderUtil;

    @Autowired
    private BorrowRepository borrowRepository;

    @Override
    public Mono<BorrowResponseDto> borrow(@SSN String ssn, @ISBN String isbn) {
        return borrowerFinderUtil.find(ssn)
                .zipWith(bookFinderUtil.find(isbn))
                .flatMap(tuple -> {
                    Borrow borrow = BorrowBuilder
                            .create()
                            .withBorrower(tuple.getT1())
                            .withBook(tuple.getT2())
                            .build();
                    return borrowRepository.save(borrow);
                })
                .flatMap(savedBorrow -> Mono.just(BorrowResponseMapper.map(savedBorrow)));
    }



}
