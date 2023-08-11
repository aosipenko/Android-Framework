package org.prog.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.prog.beans.MyBean;
import org.prog.rest.RestClient;
import org.prog.util.DataHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.stream.Collectors;

public class ApacheStepsImproved {

    @Autowired
    @Qualifier("beanOne")
    private MyBean beanOne;

    @Autowired
    @Qualifier("beanTwo")
    private MyBean beanTwo;

    @Autowired
    private DataHolder dataHolder;

    private final RestClient restClient = new RestClient();

    @Given("A request to {string} as {string}")
    public void addHost(String host, String alias) {
        beanOne.setBeanValue("Test value for beanOne alias " + alias);
        beanTwo.setBeanValue("Test value for beanTwo alias " + alias);
        dataHolder.add(alias, host);
    }

    @Given("A path {string} as {string}")
    public void addPath(String path, String alias) {
        dataHolder.add(alias, path);
    }

    @Given("Query params {string}:")
    public void addParams(String alias, DataTable dataTable) {
        List<BasicNameValuePair> queryParams = dataTable.asMap().entrySet().stream().map(
                        entry -> new BasicNameValuePair(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
        dataHolder.add(alias, queryParams);
    }

    @When("I make request to {string} at {string} with {string} as {string}")
    public void makeRequest(String hostAlias, String pathAlias, String queryAlias, String responseAlias) {
        String hostName = dataHolder.getWithDynamicType(hostAlias);
        String path = dataHolder.getWithDynamicType(pathAlias);
        List<NameValuePair> queryParams = dataHolder.getWithDynamicType(queryAlias);

        dataHolder.add(responseAlias, restClient.doGet(hostName, path, queryParams));
    }


    private ObjectMapper mapper() {
        return new ObjectMapper();
    }
}
