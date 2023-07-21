package org.prog.steps;

import com.beust.ah.A;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.prog.dto.ResultsDto;
import org.prog.rest.RestClient;

import java.util.ArrayList;
import java.util.List;

public class ApacheSteps {

    private final RestClient restClient = new RestClient();

    private static String hostName;
    private static String requestPath;
    private static List<NameValuePair> queryParams;
    private static HttpEntity responseEntity;

    private static List<ResultsDto> dtos;

    @Given("A request to {string}")
    public void setRequestHost(String host) {
        hostName = host;
    }

    @Given("A request with path {string}")
    public void setRequestPath(String path) {
        requestPath = path;
    }

    @Given("A request with queryParams")
    public void setRequestPath(DataTable dataTable) {
        if (queryParams == null) {
            queryParams = new ArrayList<>();
        }
        dataTable.asMap().entrySet().stream().forEach(
                entry -> queryParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue())));
    }

    @When("execute this request")
    public void executeRequest() {
        responseEntity = restClient.doGet(hostName, requestPath, queryParams);
    }

    @SneakyThrows
    @Then("i see list of names")
    public void printNames() {
        ResultsDto dto = mapper().readValue(EntityUtils.toString(responseEntity), ResultsDto.class);
        if (dtos == null){
            dtos = new ArrayList<>();
        }
        dtos.add(dto);
        dto.getResults().forEach(r -> System.out.println(r.getName().getFirst()));
    }

    @Given("reset request state")
    public void resetState() {
        hostName = null;
        requestPath = null;
        if (queryParams != null) {
            queryParams.clear();
        }
    }

    private ObjectMapper mapper() {
        return new ObjectMapper();
    }
}
