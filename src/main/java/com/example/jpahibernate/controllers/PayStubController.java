package com.example.jpahibernate.controllers;

import com.example.jpahibernate.entities.PayStub;
import com.example.jpahibernate.repositories.PayStubRepository;
import com.example.jpahibernate.services.PayStubService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PayStubController {

    private final PayStubService payStubService;

    @PostMapping(value = "/employees/{empId}/paystub")
    public PayStub addPayStub(@PathVariable int empId, @RequestBody PayStub payStub) {
        return payStubService.addPayStub(empId, payStub);
    }

    @DeleteMapping(value = "/employees/{empId}/paystub/{id}")
    public void deletePayStub(@PathVariable int empId, @PathVariable int id) {
        payStubService.deletePaystub(empId, id);
    }
}
