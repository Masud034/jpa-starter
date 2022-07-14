package com.example.jpahibernate.controllers;

import com.example.jpahibernate.entities.AccessCard;
import com.example.jpahibernate.services.AccessCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccessCardController {

    private final AccessCardService accessCardService;

    @PostMapping(value = "/employee/{empId}/accesscard")
    public AccessCard addAccessCard(@PathVariable int empId, @RequestBody AccessCard accessCard) {
        return accessCardService.addAccessCard(empId, accessCard);
    }
}
