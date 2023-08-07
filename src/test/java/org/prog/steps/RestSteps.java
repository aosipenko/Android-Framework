package org.prog.steps;

import com.jayway.jsonpath.Criteria;
import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.prog.dto.ResultsDto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RestSteps {

    @Given("I make test rest request")
    public void makeGetRequest() {
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.get("https://randomuser.me/api/?inc=gender,name,nat&noinfo&results=3");
        String responseBody = response.prettyPrint();
        response.then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON);

        Filter femaleFilter = Filter.filter(Criteria.where("gender").eq("Female"));
        Filter maleFilter = Filter.filter(Criteria.where("gender").eq("Male"));
        List<Map<String, Object>> women =
                JsonPath.parse(responseBody).read("$['results'][?]", femaleFilter);
        List<Map<String, Object>> men =
                JsonPath.parse(responseBody).read("$['results'][?]", maleFilter);
        System.out.println(women.size());
        System.out.println(men.size());
    }

    @Given("I make test DTO rest request")
    public void makeGetReqeustWithDto() {
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.get("https://randomuser.me/api/?inc=login,name&noinfo&results=30");
        ResultsDto resultsDto = response.as(ResultsDto.class);
        resultsDto.getResults().forEach(r -> System.out.println(r.getName().getFirst()));
        resultsDto.getResults().stream().filter(r -> r.getGender().equalsIgnoreCase("male")).collect(Collectors.toList());
    }
}

