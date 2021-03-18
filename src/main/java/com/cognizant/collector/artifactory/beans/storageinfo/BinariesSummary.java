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
import lombok.Data;
/**
 * BinariesSummary
 * @author Cognizant
 */

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
