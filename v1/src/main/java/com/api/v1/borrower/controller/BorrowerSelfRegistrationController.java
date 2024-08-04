package com.api.v1.borrower.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.borrower.dtos.BorrowerRequest;
import com.api.v1.borrower.dtos.BorrowerResponse;
import com.api.v1.borrower.services.BorrowerSelfRegistrationService;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/borrowers")
class BorrowerSelfRegistrationController {

    @Autowired
    private BorrowerSelfRegistrationService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<BorrowerResponse> selfRegister(@Valid @RequestBody BorrowerRequest request) {
        return service.sefRegister(request);
    }

}