package com.cognizant.collector.artifactory.config;

import com.cognizant.collector.artifactory.client.ArtifactoryClient;
import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;
@Configuration
public class GlobalConfiguration {
    @Value("${artifactory.url}")
    private String artifactoryUrl;
    @Bean
    public ArtifactoryClient getArtifactoryClient() {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .client(new OkHttpClient())
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .logger(new Slf4jLogger(ArtifactoryClient.class))
                .logLevel(Logger.Level.FULL)
                .target(ArtifactoryClient.class, artifactoryUrl);
    }
}
