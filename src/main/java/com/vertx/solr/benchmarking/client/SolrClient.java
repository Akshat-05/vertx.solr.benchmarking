package com.vertx.solr.benchmarking.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vertx.solr.benchmarking.pojo.SolrResponse;
import io.netty.handler.codec.http.HttpStatusClass;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.client.WebClient;

import static com.vertx.solr.benchmarking.constants.URLConstants.SOLR_URL;

public class SolrClient {

  private ObjectMapper objectMapper;
  private WebClient client;

  public SolrClient(Vertx vertx) {
    objectMapper = new ObjectMapper();
    client = WebClient.create(vertx);
  }

  public void callAsync(RoutingContext context) {
    client
      .getAbs(SOLR_URL)
      .send()
      .onSuccess(response -> {
        try{
          SolrResponse res = objectMapper.readValue(response.bodyAsString(), SolrResponse.class);
          context.response().setStatusCode(200)
            .putHeader("content-type", "application/json; charset=utf-8")
            .end(response.bodyAsString());
        } catch (Exception e){
          System.out.println("Something went wrong " + e.getMessage());
        }
      })
      .onFailure(err ->
        System.out.println("Something went wrong " + err.getMessage()));

  }

}
