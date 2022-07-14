package com.example.jpahibernate.controllers;

import com.example.jpahibernate.entities.PayStub;
import com.example.jpahibernate.repositories.PayStubRepository;
import com.example.jpahibernate.services.PayStubService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PayStubController {

    private final PayStubService payStubService;

    @PostMapping(value = "employee/{empId}/paystub/add")
    public PayStub addPayStub(@PathVariable int empId, @RequestBody PayStub payStub) {
        return payStubService.addPayStub(empId, payStub);
    }
}
