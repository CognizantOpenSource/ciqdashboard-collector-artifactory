package com.cognizant.collector.artifactory;

import com.cognizant.collector.artifactory.component.ArtifactoryComponent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ArtifactoryApplicationTests {
    @Autowired
    ArtifactoryComponent artifactoryComponent;

    @Test
    void contextLoads() {
    }

	@Test
	public void update(){
    	artifactoryComponent.getArtifactoryUpdates();
	}
}
