package com.api.v1.borrow.mappers;

import java.util.Objects;

import com.api.v1.book.mappers.BookResponseMapper;
import com.api.v1.borrow.domain.Borrow;
import com.api.v1.borrow.dtos.BorrowResponseDto;
import com.api.v1.borrower.mappers.BorrowerResponseMapper;

public class BorrowResponseMapper {

    public static BorrowResponseDto map(Borrow borrow) {
        return new BorrowResponseDto(
                BookResponseMapper.map(Objects.requireNonNull(borrow.getBook())),
                BorrowerResponseMapper.map(Objects.requireNonNull(borrow.getBorrower())),
                borrow.getBorrowedDate(),
                borrow.getDueDate(),
                borrow.getExtendedDueDate(),
                borrow.getReturnedDate()
        );
    }

}
