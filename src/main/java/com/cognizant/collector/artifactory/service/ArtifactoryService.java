/*
 * © [2021] Cognizant. All rights reserved.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.cognizant.collector.artifactory.service;

import com.cognizant.collector.artifactory.beans.buildinfo.BuildInfo;
import com.cognizant.collector.artifactory.beans.storageinfo.RepositoryStats;
import com.cognizant.collector.artifactory.beans.storageinfo.StorageInfo;
import com.cognizant.collector.artifactory.db.repo.ArtifactoryBuildRepo;
import com.cognizant.collector.artifactory.db.repo.ArtifactoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * ArtifactoryService
 * @author Cognizant
 */

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
