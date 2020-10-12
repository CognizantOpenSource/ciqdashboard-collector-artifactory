package com.cognizant.collector.artifactory.db.repo;

import com.cognizant.collector.artifactory.beans.buildinfo.BuildInfo;
import com.cognizant.collector.artifactory.beans.storageinfo.StorageInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArtifactoryBuildRepo extends MongoRepository<BuildInfo,String> {

}
