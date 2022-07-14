package com.example.jpahibernate.controllers;

import com.example.jpahibernate.entities.EmailGroup;
import com.example.jpahibernate.services.EmailGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmailGroupController {

    private final EmailGroupService emailGroupService;

    @PostMapping(value = "/employee/{empId}/group")
    public EmailGroup addEmailGroup(@PathVariable int empId, @RequestBody EmailGroup emailGroup) {
        return emailGroupService.addEmailGroup(empId, emailGroup);
    }

    @GetMapping(value = "/group/{groupId}")
    public EmailGroup getEmailGroup(@PathVariable int groupId) {
        return emailGroupService.getEmailGroup(groupId);
    }
}
