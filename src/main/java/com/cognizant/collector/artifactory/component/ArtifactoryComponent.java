package com.cognizant.collector.artifactory.component;

import com.cognizant.collector.artifactory.beans.storageinfo.Artifacts;
import com.cognizant.collector.artifactory.beans.buildinfo.Build;
import com.cognizant.collector.artifactory.beans.buildinfo.BuildData;
import com.cognizant.collector.artifactory.beans.buildinfo.BuildRuns;
import com.cognizant.collector.artifactory.beans.storageinfo.RepositoryStats;
import com.cognizant.collector.artifactory.beans.storageinfo.StorageInfo;
import com.cognizant.collector.artifactory.client.ArtifactoryClient;
import com.cognizant.collector.artifactory.db.impl.CustomArtifactoryRepository;
import com.cognizant.collector.artifactory.service.ArtifactoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
@Slf4j
public class ArtifactoryComponent {
    @Autowired
    ArtifactoryCommonUtility commonUtility;
    @Autowired
    ArtifactoryClient client;
    @Autowired
    ArtifactoryService artifactoryService;
    @Autowired
    CustomArtifactoryRepository customArtifactoryRepository;


    private HttpHeaders requestHeader = new HttpHeaders();

    @PostConstruct
    public void postConstructMethod() {
        requestHeader = commonUtility.getHeaders();
    }

    public BuildData getBuildDetails() {
        return client.getAllBuilds(requestHeader);
    }

    public StorageInfo getStrorageInfo() {
        StorageInfo storageInfo = client.getStorageInfo(requestHeader);
        return storageInfo;
    }

    public void getArtifactoryUpdates() {
        StorageInfo storageInfo = getStrorageInfo();
        getBuildInfo();
        getStorageStats(storageInfo);
    }

    public void getBuildInfo() {
        BuildData builds = getBuildDetails();
        builds.getBuildList().forEach(build -> {
            BuildRuns buildRuns = client.getBuildRuns(requestHeader, build.getUri());
            buildRuns.getBuildNumbers().forEach(build1 -> {
                Build buildInfo = client.getBuildInfo(requestHeader, build.getUri(), build1.getUri());
                artifactoryService.saveBuildInfo(buildInfo.getBuildInfo());
            });
        });
    }

    public void getStorageStats(StorageInfo storageInfo) {
        storageInfo.getRepositoriesStorageSummaryList().forEach(repositoriesStorageSummary -> {
            if ((!repositoriesStorageSummary.getRepoType().equals("VIRTUAL")) && (!repositoriesStorageSummary.getRepoKey().equals("TOTAL"))) {
                Artifacts artifacts = client.getArtifacts(requestHeader, repositoriesStorageSummary.getRepoKey());
                if (artifacts.getResults() != null) {
                    artifacts.getResults().forEach(results -> {
                        RepositoryStats repositoryInfo = getArtifactsInfo(repositoriesStorageSummary.getRepoKey(), results.getUri().split(repositoriesStorageSummary.getRepoKey())[1]);
                        repositoryInfo.setRepoType(repositoriesStorageSummary.getRepoType());
                        repositoryInfo.setPackageType(repositoriesStorageSummary.getPackageType());
                        updateStorageStats(repositoryInfo);
                    });
                }
            }
        });
    }

    public void updateStorageStats(RepositoryStats repositoryInfo) {
        RepositoryStats artifacts = customArtifactoryRepository.getArtifactory(repositoryInfo.getRepo(), repositoryInfo.getPath());
        if (artifacts != null) {
            repositoryInfo.setId(artifacts.getId());
        }
        artifactoryService.saveStorageInfo(repositoryInfo);
    }

    public RepositoryStats getArtifactsInfo(String repoName, String path) {
        RepositoryStats repositoryStats = client.getFolderStats(requestHeader, repoName, path);
        RepositoryStats repositoryInfo = client.getFolderInfo(requestHeader, repoName, path);
        repositoryInfo.setDownloadCount(repositoryStats.getDownloadCount());
        repositoryInfo.setLastDownloadedDate(new Date(repositoryStats.get_lastDownloaded()));
        repositoryInfo.setLastDownloadedBy(repositoryStats.getLastDownloadedBy());
        repositoryInfo.setRemoteDownloadCount(repositoryStats.getRemoteDownloadCount());
        repositoryInfo.setRemoteLastDownloadedDate(new Date(repositoryStats.get_remoteLastDownloaded()));
        return repositoryInfo;
    }


}
