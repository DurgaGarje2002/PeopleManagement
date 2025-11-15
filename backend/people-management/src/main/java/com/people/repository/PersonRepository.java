package com.people.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.people.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
