package com.example.jpahibernate.repositories;

import com.example.jpahibernate.entities.AccessCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessCardRepository extends JpaRepository<AccessCard, Integer> {
}
