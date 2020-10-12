package com.cognizant.collector.artifactory.beans.buildinfo;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "runChecks",
        "includePublishedArtifacts",
        "autoDiscover",
        "licenseViolationsRecipientsList",
        "scopesList"
})
public class LicenseControl {

    @JsonProperty("runChecks")
    public Boolean runChecks;
    @JsonProperty("includePublishedArtifacts")
    public Boolean includePublishedArtifacts;
    @JsonProperty("autoDiscover")
    public Boolean autoDiscover;
    @JsonProperty("licenseViolationsRecipientsList")
    public String licenseViolationsRecipientsList;
    @JsonProperty("scopesList")
    public String scopesList;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
