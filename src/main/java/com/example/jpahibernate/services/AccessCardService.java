package com.example.jpahibernate.services;

import com.example.jpahibernate.entities.AccessCard;
import com.example.jpahibernate.entities.Employee;
import com.example.jpahibernate.repositories.AccessCardRepository;
import com.example.jpahibernate.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccessCardService {

    private final AccessCardRepository accessCardRepository;

    private final EmployeeRepository employeeRepository;

    public AccessCard addAccessCard(int empId, AccessCard accessCard) {
        Optional<Employee> employee = employeeRepository.findById(empId);
        final AccessCard[] savedAccessCard = new AccessCard[1];
        employee.ifPresentOrElse((emp) -> {
                    savedAccessCard[0] = accessCardRepository.save(accessCard);
                    emp.setCard(savedAccessCard[0]);
                    employeeRepository.save(emp);
                },
                () -> {
                    throw new RuntimeException("Employee Not Found");
                });
        return savedAccessCard[0];
    }
}
