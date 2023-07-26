package org.prog.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.prog.dto.LoginDto;
import org.prog.dto.NameDto;
import org.prog.dto.ResultsDto;
import org.prog.dto.UserDto;
import org.prog.util.DataHolder;
import org.testng.Assert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class SqlSteps {

    private final Random random = new Random();

    @SneakyThrows
    @When("I store {string} in DB")
    public void storeUserSetToDb(String alias) {
        HttpEntity entity = DataHolder.getInstance().getWithDynamicType(alias);
        ResultsDto dto = mapper().readValue(EntityUtils.toString(entity), ResultsDto.class);
        dto.getResults().forEach(r -> {
            try {
                String createPerson = String.format("insert into Persons (LastName, FirstName, Title, Gender) VALUES ('%s', '%s', '%s', '%s')",
                        r.getName().getLast(),
                        r.getName().getFirst(),
                        r.getName().getTitle(),
                        r.getGender());
                executeSql(createPerson, false);
                String personId = getPersonIdByFirstAndLastName(r.getName().getFirst(), r.getName().getLast());
                String createLogin = String.format("insert into Credentials (PersonID, Login, Password) VALUES ('%s','%s','%s')",
                        personId, r.getLogin().getUsername(), r.getLogin().getPassword());
                executeSql(createLogin, false);
                System.out.println("Inject user OK: " + r.getName());
            } catch (Exception e) {
                System.err.println("Failed to insert " + r.getName());
            }
        });
    }

    @SneakyThrows
    @Given("I add user with name {string} last name {string} title {string} gender {string}")
    public void addData(String name, String lastName, String title, String gender) {
        String query = String.format("insert into Persons (LastName, FirstName, Title, Gender) VALUES ('%s', '%s', '%s', '%s')",
                lastName, name, title, gender);
        executeSql(query, false);
    }

    @Given("I update data in DB")
    public void updateData() {

    }

    @SneakyThrows
    @Given("I pick random user from DB as {string}")
    public void readData(String alias) {
        ResultSet resultSet = null;
        List<UserDto> userDtos = new ArrayList<>();
        String query = "select Persons.FirstName as 'Name'," +
                "Persons.LastName as 'Last'," +
                "Credentials.Login as 'Login'," +
                "Credentials.Password as 'Password'" +
                "from Persons join Credentials on Persons.PersonID = Credentials.PersonID;";
        try {
            resultSet = executeSql(query, true).get();
            while (resultSet.next()) {
                LoginDto loginDto = new LoginDto();
                NameDto nameDto = new NameDto();

                loginDto.setUsername(resultSet.getString("Login"));
                loginDto.setPassword(resultSet.getString("Password"));

                nameDto.setFirst(resultSet.getString("Name"));
                nameDto.setLast(resultSet.getString("Last"));

                UserDto userDto = new UserDto();
                userDto.setName(nameDto);
                userDto.setLogin(loginDto);
                userDtos.add(userDto);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("SQL went wrong!");
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
        }
        DataHolder.getInstance().add(alias, userDtos.get(random.nextInt(userDtos.size())));
    }

    @Given("I remove data from DB")
    public void deleteData() {
    }

    @SneakyThrows
    private Optional<ResultSet> executeSql(String query, boolean hasResults) {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "password");
        Statement statement = connection.createStatement();
        try {
            if (hasResults) {
                return Optional.of(statement.executeQuery(query));
            } else {
                statement.execute(query);
                return Optional.empty();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (!hasResults) {
                statement.close();
                connection.close();
            }
        }
    }

    private ObjectMapper mapper() {
        return new ObjectMapper();
    }

    @SneakyThrows
    private String getPersonIdByFirstAndLastName(String firstName, String lastname) {
        ResultSet resultSet = null;
        String query = String.format("select * from Persons where FirstName = '%s' and LastName = '%s'",
                firstName, lastname);
        try {
            resultSet = executeSql(query, true).get();
            while (resultSet.next()) {
                return resultSet.getString("PersonID");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("SQL went wrong!");
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
        }
        throw new RuntimeException("No results were found for " + firstName + " " + lastname);
    }

    @Then("I print {string}")
    public void iPrint(String alias) {
        UserDto dto = DataHolder.getInstance().getWithDynamicType(alias);
        System.out.println(dto.getName().getFirst() + " " + dto.getName().getLast());
        System.out.println(dto.getLogin().getUsername() + " " + dto.getLogin().getPassword());
    }
}

