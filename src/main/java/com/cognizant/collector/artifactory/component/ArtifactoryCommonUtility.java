package com.cognizant.collector.artifactory.component;

import com.cognizant.collector.artifactory.beans.ArtifactoryProperties;
import com.cognizant.collector.artifactory.config.CustomBasicAuthentication;
import com.cognizant.collector.artifactory.constants.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static com.cognizant.collector.artifactory.constants.Constant.SOURCE;

@Component
public class ArtifactoryCommonUtility {
    private HttpHeaders headers = new HttpHeaders();
    public static String collectionName;
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

    @Value("${spring.data.mongodb.collection}")
    public void setCollectionName(String collectionName) {
        this.collectionName = SOURCE+collectionName;
    }

    public static String getCollectionName(){
        return collectionName;
    }

}
