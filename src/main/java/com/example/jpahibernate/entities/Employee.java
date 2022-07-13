package com.example.jpahibernate.entities;

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

    @OneToOne(fetch = FetchType.LAZY)
    private AccessCard card;

    @OneToMany
    private List<PayStub> payStub = new ArrayList<>();
}
