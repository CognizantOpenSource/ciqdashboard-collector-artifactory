package com.cognizant.collector.artifactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties
@EnableScheduling
@EnableAutoConfiguration
@EnableEncryptableProperties
public class ArtifactoryApplication {
	public static void main(String[] args) {
		SpringApplication.run(ArtifactoryApplication.class, args);
	}
}
