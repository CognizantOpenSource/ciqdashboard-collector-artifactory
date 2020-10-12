package com.cognizant.collector.artifactory.service;

import com.cognizant.collector.artifactory.beans.buildinfo.BuildInfo;
import com.cognizant.collector.artifactory.beans.storageinfo.RepositoryStats;
import com.cognizant.collector.artifactory.beans.storageinfo.StorageInfo;
import com.cognizant.collector.artifactory.db.repo.ArtifactoryBuildRepo;
import com.cognizant.collector.artifactory.db.repo.ArtifactoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtifactoryService {
    @Autowired
    ArtifactoryRepo artifactoryRepo;
    @Autowired
    ArtifactoryBuildRepo artifactoryBuildRepo;

    public void saveStorageInfo(RepositoryStats storageInfo){
        artifactoryRepo.save(storageInfo);
    }

    public void saveBuildInfo(BuildInfo buildInfo){
        artifactoryBuildRepo.save(buildInfo);
    }
}
