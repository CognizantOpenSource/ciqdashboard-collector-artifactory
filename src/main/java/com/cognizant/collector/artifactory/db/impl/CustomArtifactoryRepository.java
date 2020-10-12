package com.cognizant.collector.artifactory.db.impl;

import com.cognizant.collector.artifactory.beans.storageinfo.RepositoryStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

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
