package com.example.jpahibernate.repositories;

import com.example.jpahibernate.entities.PayStub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayStubRepository extends JpaRepository<PayStub, Integer> {

}
