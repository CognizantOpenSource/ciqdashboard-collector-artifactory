package com.cognizant.collector.artifactory.beans.storageinfo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "repoKey",
        "repoType",
        "foldersCount",
        "filesCount",
        "usedSpace",
        "itemsCount",
        "packageType",
        "percentage"
})
@Data
public class RepositoriesStorageSummary {
    @JsonProperty("repoKey")
    private String repoKey;
    @JsonProperty("repoType")
    private String repoType;
    @JsonProperty("foldersCount")
    private int foldersCount;
    @JsonProperty("filesCount")
    private int filesCount;
    @JsonProperty("usedSpace")
    private String usedSpace;
    @JsonProperty("itemsCount")
    private int itemsCount;
    @JsonProperty("packageType")
    private String packageType;
    @JsonProperty("percentage")
    private String percentage;
}
