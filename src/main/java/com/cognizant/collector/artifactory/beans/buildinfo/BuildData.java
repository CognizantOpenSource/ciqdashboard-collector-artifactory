package com.cognizant.collector.artifactory.beans.buildinfo;

import com.cognizant.collector.artifactory.beans.buildinfo.Build;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "builds",
        "uri"
})
public class BuildData {
    @JsonProperty("builds")
    @JsonAlias("buildsNumbers")
    private List<Build> buildList =null;
    private String uri;
}
