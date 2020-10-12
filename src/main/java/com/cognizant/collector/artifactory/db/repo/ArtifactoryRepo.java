package com.cognizant.collector.artifactory.db.repo;

import com.cognizant.collector.artifactory.beans.storageinfo.RepositoryStats;
import com.cognizant.collector.artifactory.beans.storageinfo.StorageInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArtifactoryRepo extends MongoRepository<RepositoryStats,String> {

}
