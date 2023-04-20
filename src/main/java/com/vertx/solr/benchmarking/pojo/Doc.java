package com.vertx.solr.benchmarking.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Doc {

    @JsonProperty("id")
    private String id;
    @JsonProperty("content_id")
    private String contentId;
    @JsonProperty("content_name")
    private List<String> contentName;

}
