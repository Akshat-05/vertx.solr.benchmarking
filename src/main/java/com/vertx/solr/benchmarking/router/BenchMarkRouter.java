package com.vertx.solr.benchmarking.router;

import com.vertx.solr.benchmarking.client.SolrClient;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public class BenchMarkRouter {
  Vertx vertx;
  public BenchMarkRouter(Vertx vertx){
    this.vertx = vertx;
  }
  public void route(Router router) {
    SolrClient solrClient = new SolrClient(vertx);
    router.get("/vertx")
      .handler(solrClient::callAsync);
  }
}
