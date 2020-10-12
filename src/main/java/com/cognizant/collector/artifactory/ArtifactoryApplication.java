package com.cognizant.collector.artifactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties
@EnableScheduling
public class ArtifactoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArtifactoryApplication.class, args);

	}

}
