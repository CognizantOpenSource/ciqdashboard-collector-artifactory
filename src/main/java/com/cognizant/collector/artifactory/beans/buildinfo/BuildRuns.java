package com.cognizant.collector.artifactory.beans.buildinfo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "buildsNumbers",
        "uri"
})
public class BuildRuns {
    @JsonProperty("buildsNumbers")
    List<Build> buildNumbers=null;
    private String uri;
}
