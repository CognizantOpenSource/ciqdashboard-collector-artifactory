package com.cognizant.collector.artifactory.component;

import com.cognizant.collector.artifactory.beans.ArtifactoryProperties;
import com.cognizant.collector.artifactory.config.CustomBasicAuthentication;
import com.cognizant.collector.artifactory.constants.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static com.cognizant.collector.artifactory.constants.Constant.SOURCE_BUILD;

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
        this.buildCollectionName = SOURCE_BUILD+collectionName;
    }

    public static String getStorageCollectionName(){
        return storageCollectionName;
    }


}
