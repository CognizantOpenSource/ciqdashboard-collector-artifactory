package com.cognizant.collector.artifactory.beans.storageinfo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "binariesCount",
        "binariesSize",
        "artifactsSize",
        "optimization",
        "itemsCount",
        "artifactsCount"
})
@Data
public class BinariesSummary {
    @JsonProperty("binariesCount")
    private int binariesCount;
    @JsonProperty("binariesSize")
    private String binariesSize;
    @JsonProperty("artifactsSize")
    private String artifactsSize;
    @JsonProperty("optimization")
    private String optimization;
    @JsonProperty("itemsCount")
    private int itemsCount;
    @JsonProperty("artifactsCount")
    private int artifactsCount;

}
