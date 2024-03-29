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

package com.cognizant.collector.artifactory.component;

import com.cognizant.collector.artifactory.beans.ArtifactoryProperties;
import com.cognizant.collector.artifactory.config.CustomBasicAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static com.cognizant.collector.artifactory.constants.Constant.SOURCE_BUILD;
import static com.cognizant.collector.artifactory.constants.Constant.SOURCE_STORAGE;
/**
 * ArtifactoryCommonUtility - Configuration class for auth header
 * @author Cognizant
 */

@Component
public class ArtifactoryCommonUtility {
    private HttpHeaders headers = new HttpHeaders();
    static String buildCollectionName;
    static String storageCollectionName;
    @Autowired
    private ArtifactoryProperties properties;

    @Autowired
    CustomBasicAuthentication customBasicAuthentication;

    @PostConstruct
    private void postConstructMethod() {
        headers.setAll(customBasicAuthentication.getBasicAuthentication(properties.getUsername(), properties.getToken()));
    }

    public HttpHeaders getHeaders(){
        return headers;
    }

    @Value("${spring.data.mongodb.collection.build}")
    public void setBuildCollectionName(String collectionName) {
        this.buildCollectionName = SOURCE_BUILD+collectionName;
    }

    public static String getBuildCollectionName(){
        return buildCollectionName;
    }

    @Value("${spring.data.mongodb.collection.storage}")
    public void setStorageCollectionName(String collectionName) {
        this.storageCollectionName = SOURCE_STORAGE+collectionName;
    }

    public static String getStorageCollectionName(){
        return storageCollectionName;
    }


}
