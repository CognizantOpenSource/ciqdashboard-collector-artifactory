package com.cognizant.collector.artifactory.beans;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "artifactory")
@Slf4j
@Data
public class ArtifactoryProperties {
    private String url;
    private String token;
    private String username;
}
