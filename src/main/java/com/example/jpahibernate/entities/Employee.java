package com.example.jpahibernate.entities;

import com.example.jpahibernate.enums.EmployeeType;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Enumerated(EnumType.STRING)
    private EmployeeType type;

    @OneToOne
    private AccessCard card;

    @OneToMany(mappedBy = "employee") //mapped by stops JPA from creating separate table for Employee-Paystub
    private List<PayStub> payStub = new ArrayList<>();

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "email_group_subscriptions",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "email_group_subscription_id")
    )
    private List<EmailGroup> emailGroupList = new ArrayList<>();
}
