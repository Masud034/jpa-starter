package com.example.jpahibernate.services;

import com.example.jpahibernate.entities.EmailGroup;
import com.example.jpahibernate.entities.Employee;
import com.example.jpahibernate.repositories.EmailGroupRepository;
import com.example.jpahibernate.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmailGroupService {

    private final EmailGroupRepository emailGroupRepository;

    private final EmployeeRepository employeeRepository;

    public EmailGroup addEmailGroup(int empId, EmailGroup emailGroup) {
        Optional<Employee> employee = employeeRepository.findById(empId);
        final EmailGroup[] savedEmailGroup = new EmailGroup[1];

        employee.ifPresentOrElse((emp) -> {
                    emailGroup.getEmployeeList().add(emp);
                    savedEmailGroup[0] = emailGroupRepository.save(emailGroup);

                    emp.getEmailGroupList().add(savedEmailGroup[0]);
                    employeeRepository.save(emp);
                },
                () -> {
                    throw new RuntimeException("Employee Not Found");
                }
        );
        return savedEmailGroup[0];
    }
}
