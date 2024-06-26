package com.api.v1.borrower;

import com.api.v1.borrower.self_register.SelfRegisterBorrowerDTO;

public interface BorrowerBuilder {

    BorrowerBuilderImpl createFromDTO(SelfRegisterBorrowerDTO dto);
    BorrowerBuilderImpl withMiddleName(String middleName);
    Borrower build();

}
