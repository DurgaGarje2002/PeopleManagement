package com.people.service;

import com.people.exception.ResourceNotFoundException;
import com.people.model.Person;
import com.people.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repo;

    public List<Person> getAll() {
        return repo.findAll();
    }

    public Person create(Person p) {
        return repo.save(p);
    }

    public Person getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found with ID: " + id));
    }

    public Person update(Long id, Person p) {
        Person existing = getById(id);

        existing.setName(p.getName());
        existing.setEmail(p.getEmail());
        existing.setRole(p.getRole());
        existing.setSalary(p.getSalary());

        return repo.save(existing);
    }

    public void delete(Long id) {
        Person existing = getById(id);
        repo.delete(existing);
    }
}
