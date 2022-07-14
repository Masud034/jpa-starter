package com.example.jpahibernate.repositories;

import com.example.jpahibernate.entities.EmailGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailGroupRepository extends JpaRepository<EmailGroup, Integer> {
}
