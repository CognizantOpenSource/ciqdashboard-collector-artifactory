package com.cognizant.collector.artifactory.beans.storageinfo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("source_artifactoryStorage")
@CompoundIndex(name = "repoName", def = "{'repo' : 1, 'path': 1}", unique = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "uri",
        "downloadCount",
        "lastDownloaded",
        "lastDownloadedBy",
        "remoteDownloadCount",
        "remoteLastDownloaded",
        "repo",
        "path",
        "created",
        "createdBy",
        "lastModified",
        "modifiedBy",
        "downloadUri",
        "mimeType",
        "size",
        "lastUpdated",
        "children",
        "uri"
})
public class RepositoryStats {

    @Id
    private String id;

    @JsonProperty("uri")
    private String uri;
    @JsonProperty("downloadCount")
    private Integer downloadCount;
    @JsonProperty("lastDownloaded")
    private Long _lastDownloaded;
    @JsonProperty("lastDownloadedBy")
    private String lastDownloadedBy;
    @JsonProperty("remoteDownloadCount")
    private Integer remoteDownloadCount;
    @JsonProperty("remoteLastDownloaded")
    private Long _remoteLastDownloaded;
    private Date lastDownloadedDate;
    private Date remoteLastDownloadedDate;


    @JsonProperty("repo")
    private String repo;
    @JsonProperty("repoType")
    private String repoType;
    @JsonProperty("packageType")
    private String packageType;
    @JsonProperty("path")
    private String path;
    @JsonProperty("created")
    private Date created;
    @JsonProperty("createdBy")
    private String createdBy;
    @JsonProperty("lastModified")
    private Date lastModified;
    @JsonProperty("modifiedBy")
    private String modifiedBy;
    @JsonProperty("downloadUri")
    private String downloadUri;
    @JsonProperty("mimeType")
    private String mimeType;
    @JsonProperty("size")
    private Long size;
    @JsonProperty("lastUpdated")
    private Date lastUpdated;
    @JsonProperty("children")
    private List<Child> children = null;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}

