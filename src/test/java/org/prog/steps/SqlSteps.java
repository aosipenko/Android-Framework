package org.prog.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.prog.dto.ResultsDto;
import org.prog.util.DataHolder;
import org.testng.Assert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;

public class SqlSteps {

    @SneakyThrows
    @When("I store {string} in DB")
    public void storeUserSetToDb(String alias) {
        HttpEntity entity = DataHolder.getInstance().getWithDynamicType(alias);
        ResultsDto dto = mapper().readValue(EntityUtils.toString(entity), ResultsDto.class);
        dto.getResults().forEach(r -> {
            try {
                String query = String.format("insert into Persons (LastName, FirstName, Title, Gender) VALUES ('%s', '%s', '%s', '%s')",
                        r.getName().getLast(),
                        r.getName().getFirst(),
                        r.getName().getTitle(),
                        r.getGender());
                executeSql(query, false);
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
    @Given("I read data from DB")
    public void readData() {
        ResultSet resultSet = null;
        String query = "select * from Persons";
        try {
            resultSet = executeSql(query, true).get();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("FirstName") + " " + resultSet.getString("LastName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("SQL went wrong!");
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
        }
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
}
