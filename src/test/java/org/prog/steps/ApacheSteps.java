package org.prog.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.prog.dto.NameDto;
import org.prog.dto.ResultsDto;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ApacheSteps {

    @Given("I make test Apache Request")
    public void makeApacheRequest() throws URISyntaxException, IOException, ParseException {
        HttpEntity entity = performReqeust();
        String jsonResponse = EntityUtils.toString(entity);
        System.out.println(jsonResponse);
        ResultsDto dto = mapper().readValue(jsonResponse, ResultsDto.class);
        dto.getResults().forEach(r -> System.out.println(r.getName().getFirst()));

        System.out.println("=============================");

        String objectAsString = mapper().writeValueAsString(new NameDto("test", "test", "test"));
        System.out.println(objectAsString);
    }

    private HttpEntity performReqeust() throws IOException, URISyntaxException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(new URI("https://randomuser.me/api/?inc=gender,name,nat&noinfo&results=10"));
        httpGet.setHeader("asd", "asd");
//        httpGet.setEntity(EntityBuilder.create().setText("test").build());
        return client.execute(httpGet).getEntity();
    }

    private ObjectMapper mapper() {
        return new ObjectMapper();
    }
}
