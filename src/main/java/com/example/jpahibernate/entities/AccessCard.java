package com.example.jpahibernate.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class AccessCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private LocalDate issuedAt;

    private boolean isActive;

    @OneToOne(mappedBy = "card")
    private Employee employee;
}
