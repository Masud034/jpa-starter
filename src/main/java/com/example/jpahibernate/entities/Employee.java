package com.example.jpahibernate.entities;

import com.example.jpahibernate.enums.EmployeeType;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private EmployeeType type;

    @OneToOne
    private AccessCard card;

    @OneToMany
    private List<PayStub> payStub = new ArrayList<>();
}
