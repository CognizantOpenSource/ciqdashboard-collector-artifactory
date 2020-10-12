package com.cognizant.collector.artifactory.beans.storageinfo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "storageType",
        "storageDirectory",
        "totalSpace",
        "usedSpace",
        "freeSpace"
})
public class FileStorageSummary {
    @JsonProperty("storageType")
    private String storageType;
    @JsonProperty("storageDirectory")
    private String storageDirectory;
    @JsonProperty("totalSpace")
    private String totalSpace;
    @JsonProperty("usedSpace")
    private String usedSpace;
    @JsonProperty("freeSpace")
    private String freeSpace;
}
