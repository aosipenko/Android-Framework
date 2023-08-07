package org.prog.steps;

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
import org.prog.util.DataHolder;

import java.util.List;
import java.util.stream.Collectors;

public class ApacheStepsImproved {

    private final RestClient restClient = new RestClient();

    @Given("A request to {string} as {string}")
    public void addHost(String host, String alias) {
        DataHolder.getInstance().add(alias, host);
    }

    @Given("A path {string} as {string}")
    public void addPath(String path, String alias) {
        DataHolder.getInstance().add(alias, path);
    }

    @Given("Query params {string}:")
    public void addParams(String alias, DataTable dataTable) {
        List<BasicNameValuePair> queryParams = dataTable.asMap().entrySet().stream().map(
                entry -> new BasicNameValuePair(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
        DataHolder.getInstance().add(alias, queryParams);
    }

    @When("I make request to {string} at {string} with {string} as {string}")
    public void makeRequest(String hostAlias, String pathAlias, String queryAlias, String responseAlias) {
        String hostName = DataHolder.getInstance().getWithDynamicType(hostAlias);
        String path = DataHolder.getInstance().getWithDynamicType(pathAlias);
        List<NameValuePair> queryParams = DataHolder.getInstance().getWithDynamicType(queryAlias);

        DataHolder.getInstance().add(responseAlias, restClient.doGet(hostName, path, queryParams));
    }

    @SneakyThrows
    @Then("Print response {string}")
    public void printResponse(String responseAlias) {
        HttpEntity responseEntity = DataHolder.getInstance().getWithDynamicType(responseAlias);
        ResultsDto dto = mapper().readValue(EntityUtils.toString(responseEntity), ResultsDto.class);
        dto.getResults().forEach(r -> System.out.println(r.getName().getFirst()));
    }

    private ObjectMapper mapper() {
        return new ObjectMapper();
    }
}
