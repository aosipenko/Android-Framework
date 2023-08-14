package org.prog.steps;

import io.cucumber.java.en.Given;
import org.prog.db.repository.PersonsJpa;
import org.prog.db.table.Persons;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.atomic.AtomicReference;

public class SpringDataSteps {

    @Autowired
    private PersonsJpa personsJpa;

    @Given("Print all from DB using Spring")
    public void printAll() {
        personsJpa.findAll().forEach(p -> {
            System.out.println(p.getFirstName() + " " + p.getLastName());
        });
    }
}
