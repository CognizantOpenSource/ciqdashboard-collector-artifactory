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

package com.cognizant.collector.artifactory.db.impl;

import com.cognizant.collector.artifactory.beans.storageinfo.RepositoryStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * CustomArtifactoryRepository
 * @author Cognizant
 */

@Repository
public class CustomArtifactoryRepository {

    @Autowired
    MongoTemplate template;

    public RepositoryStats getArtifactory(String repoName, String path){
        Query query = new Query();
        query.addCriteria(Criteria.where("repo").is(repoName));
        query.addCriteria(Criteria.where("path").is(path));
        return template.findOne(query,RepositoryStats.class);
    }
}
