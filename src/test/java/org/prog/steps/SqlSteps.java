package org.prog.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.prog.db.repository.PersonsJpa;
import org.prog.db.table.Persons;
import org.prog.dto.ResultsDto;
import org.prog.dto.UserDto;
import org.prog.util.DataHolder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Slf4j
public class SqlSteps {

    private static final Logger LOG = LogManager.getLogger(SqlSteps.class);

    @Autowired
    private DataHolder dataHolder;

    @Autowired
    private PersonsJpa personsJpa;

    private final Random random = new Random();

    @SneakyThrows
    @When("I store {string} in DB")
    public void storeUserSetToDb(String alias) {
        HttpEntity entity = dataHolder.getWithDynamicType(alias);
        mapper().readValue(EntityUtils.toString(entity), ResultsDto.class)
                .getResults()
                .forEach(r -> {
                    LOG.info("Processing Person {}", r);
                    try {
                        Persons p = personsJpa.save(Persons.builder()
                                .firstName(r.getName().getFirst())
                                .lastName(r.getName().getLast())
                                .gender(r.getGender())
                                .title(r.getName().getTitle())
                                .build());
                        LOG.info("Stored in DB as {}", p);
                    } catch (Exception e) {
                        LOG.error("Failed to store user in DB!");
                    }
                });
    }

    @SneakyThrows
    @Given("I add user with name {string} last name {string} title {string} gender {string}")
    public void addData(String name, String lastName, String title, String gender) {
        personsJpa.save(Persons.builder()
                .firstName(name)
                .lastName(lastName)
                .title(title)
                .gender(gender)
                .build());
    }

    @SneakyThrows
    @Given("I pick random user from DB as {string}")
    public void readData(String alias) {
        List<UserDto> userDtos = personsJpa.findAll()
                .stream()
                .map(UserDto::fromTable)
                .collect(Collectors.toList());
        dataHolder.add(alias, userDtos.get(random.nextInt(userDtos.size())));
    }

    private ObjectMapper mapper() {
        return new ObjectMapper();
    }

    @Then("I print {string}")
    public void iPrint(String alias) {
        UserDto dto = dataHolder.getWithDynamicType(alias);
        log.info("Person: {} {}", dto.getName().getFirst(), dto.getName().getLast());
    }
}

