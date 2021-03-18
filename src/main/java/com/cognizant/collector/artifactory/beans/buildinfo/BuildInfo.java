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

package com.cognizant.collector.artifactory.beans.buildinfo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cognizant.collector.artifactory.beans.buildinfo.Agent;
import com.cognizant.collector.artifactory.beans.buildinfo.Governance;
import com.cognizant.collector.artifactory.beans.buildinfo.LicenseControl;
import com.cognizant.collector.artifactory.beans.buildinfo.VCS;
import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * BuildInfo - refers to build collection in mongodb
 * @author Cognizant
 */

@Data
@Document(collection = "#{T(com.cognizant.collector.artifactory.component.ArtifactoryCommonUtility).getBuildCollectionName()}")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "version",
        "name",
        "number",
        "type",
        "buildAgent",
        "agent",
        "started",
        "durationMillis",
        "principal",
        "artifactoryPrincipal",
        "artifactoryPluginVersion",
        "url",
        "vcs",
        "vcsRevision",
        "vcsUrl",
        "licenseControl",
        "modules",
        "governance"
})
public class BuildInfo {

    @Id
    private String id;

    @JsonProperty("version")
    public String version;
    @JsonProperty("name")
    public String name;
    @JsonProperty("number")
    public String number;
    @JsonProperty("type")
    public String type;
    @JsonProperty("buildAgent")
    public Agent buildAgent;
    @JsonProperty("agent")
    public Agent agent;
    @JsonProperty("started")
    public Date started;
    @JsonProperty("durationMillis")
    public Long durationMillis;
    @JsonProperty("principal")
    public String principal;
    @JsonProperty("artifactoryPrincipal")
    public String artifactoryPrincipal;
    @JsonProperty("artifactoryPluginVersion")
    public String artifactoryPluginVersion;
    @JsonProperty("url")
    public String url;
    @JsonProperty("vcs")
    public List<VCS> vcs = null;
    @JsonProperty("vcsRevision")
    public String vcsRevision;
    @JsonProperty("vcsUrl")
    public String vcsUrl;
    @JsonProperty("licenseControl")
    public LicenseControl licenseControl;
    @JsonProperty("governance")
    public Governance governance;
//    @JsonIgnore
//    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
//
//    @JsonAnyGetter
//    public Map<String, Object> getAdditionalProperties() {
//        return this.additionalProperties;
//    }
//
//    @JsonAnySetter
//    public void setAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//    }

}