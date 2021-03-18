/*
 * © [2021] Cognizant. All rights reserved.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

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
/**
 * RepositoryStats - refers to storage collection in mongodb
 * @author Cognizant
 */

@Data
@Document(collection = "#{T(com.cognizant.collector.artifactory.component.ArtifactoryCommonUtility).getStorageCollectionName()}")
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

