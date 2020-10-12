package com.cognizant.collector.artifactory.beans.storageinfo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "binariesSummary",
        "fileStoreSummary",
        "repositoriesSummaryList"
})
@Data
public class StorageSummary {
    @JsonProperty("binariesSummary")
    private BinariesSummary binariesSummary;
    @JsonProperty("fileStoreSummary")
    private FileStorageSummary fileStorageSummary;
    @JsonProperty("repositoriesSummaryList")
    private List<RepositoriesStorageSummary> repositoriesStorageSummaryList;
}
