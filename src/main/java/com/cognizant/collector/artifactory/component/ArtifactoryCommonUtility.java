package com.cognizant.collector.artifactory.component;

import com.cognizant.collector.artifactory.beans.ArtifactoryProperties;
import com.cognizant.collector.artifactory.config.CustomBasicAuthentication;
import com.cognizant.collector.artifactory.constants.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
@Component
public class ArtifactoryCommonUtility {
    private HttpHeaders headers = new HttpHeaders();
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
}
