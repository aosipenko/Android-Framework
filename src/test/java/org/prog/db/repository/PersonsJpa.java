package org.prog.db.repository;

import org.prog.db.table.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonsJpa extends JpaRepository<Persons, Long> {

    Optional<Persons> findByFirstNameAndLastName(String firstName, String lastName);

    void deleteByFirstNameAndLastName(String firstName, String lastName);

}
