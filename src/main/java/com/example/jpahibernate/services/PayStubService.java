package com.example.jpahibernate.services;

import com.example.jpahibernate.entities.Employee;
import com.example.jpahibernate.entities.PayStub;
import com.example.jpahibernate.repositories.EmployeeRepository;
import com.example.jpahibernate.repositories.PayStubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PayStubService {

    private final PayStubRepository payStubRepository;

    private final EmployeeRepository employeeRepository;

    public PayStub addPayStub(int empId, PayStub payStub) {
        Optional<Employee> employee = employeeRepository.findById(empId);
        final PayStub[] savedPayStub = new PayStub[1];
        employee.ifPresentOrElse((emp)-> {
                    savedPayStub[0] = payStubRepository.save(payStub);
                    emp.getPayStub().add(savedPayStub[0]);
                    employeeRepository.save(emp);
                }, ()-> {
                    throw new RuntimeException("Employee Not found");
                }
        );
        return savedPayStub[0];
    }
}
