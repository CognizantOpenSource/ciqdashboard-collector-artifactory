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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
/**
 * FileStorageSummary
 * @author Cognizant
 */

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
