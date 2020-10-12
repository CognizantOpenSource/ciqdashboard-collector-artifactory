package com.cognizant.collector.artifactory.beans.storageinfo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "storageSummary",
        "fileStoreSummary",
        "binariesSummary",
        "repositoriesSummaryList"
})
@Data
public class StorageInfo {
    @JsonProperty("storageSummary")
    private StorageSummary storageSummary;
    @JsonProperty("fileStoreSummary")
    private FileStorageSummary fileStorageSummary;
    @JsonProperty("binariesSummary")
    private BinariesSummary binariesSummary;
    @JsonProperty("repositoriesSummaryList")
    private List<RepositoriesStorageSummary> repositoriesStorageSummaryList;
}
