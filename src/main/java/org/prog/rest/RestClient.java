package org.prog.rest;

import lombok.SneakyThrows;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.net.URIBuilder;

import java.util.List;
import java.util.Optional;

public class RestClient {

    public HttpEntity doGet(String host, String path) {
        return doGet(host, 443, path);
    }

    public HttpEntity doGet(String host, int port, String path) {
        return doGet(host, port, path, List.of());
    }

    public HttpEntity doGet(String host, String path, List<NameValuePair> queryParams) {
        return doGet(host, 443, path, List.of(), queryParams);
    }

    public HttpEntity doGet(String host, int port, String path, List<NameValuePair> queryParams) {
        return doGet(host, port, path, List.of(), queryParams);
    }

    public HttpEntity doGet(String host, int port, String path, List<Header> headers, List<NameValuePair> queryParams) {
        return doGet(host, port, path, headers, queryParams, Optional.empty());
    }

    @SneakyThrows
    public HttpEntity doGet(String host, int port, String path, List<Header> headers, List<NameValuePair> queryParams, Optional<HttpEntity> body) {
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setHost(host);
        uriBuilder.setPort(port);
        uriBuilder.setPath(path);
        uriBuilder.addParameters(queryParams);
        uriBuilder.setScheme(port == 443 ? "https" : "http");

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        headers.forEach(httpGet::addHeader);
        body.ifPresent(httpGet::setEntity);
        return executeRequest(httpGet);
    }

    @SneakyThrows
    private HttpEntity executeRequest(HttpUriRequestBase requestBase) {
        CloseableHttpClient client = HttpClients.createDefault();
        return client.execute(requestBase).getEntity();
    }
}
