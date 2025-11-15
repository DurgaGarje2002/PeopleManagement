package com.people.controller;

import com.people.model.Person;
import com.people.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/people")
@CrossOrigin("*")   // Allows frontend (HTML/JS) to call backend
public class PersonController {

    @Autowired
    private PersonService service;

    // CREATE
    @PostMapping
    public ResponseEntity<Person> addPerson(@Valid @RequestBody Person p) {
        Person saved = service.create(p);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // GET ALL
    @GetMapping
    public List<Person> getAllPeople() {
        return service.getAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(
            @PathVariable Long id,
            @Valid @RequestBody Person p
    ) {
        return ResponseEntity.ok(service.update(id, p));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Person deleted successfully");
    }
}
