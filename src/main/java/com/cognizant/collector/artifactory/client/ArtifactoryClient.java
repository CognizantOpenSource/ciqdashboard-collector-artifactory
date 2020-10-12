package com.cognizant.collector.artifactory.client;

import com.cognizant.collector.artifactory.beans.storageinfo.Artifacts;
import com.cognizant.collector.artifactory.beans.buildinfo.Build;
import com.cognizant.collector.artifactory.beans.buildinfo.BuildData;
import com.cognizant.collector.artifactory.beans.buildinfo.BuildRuns;
import com.cognizant.collector.artifactory.beans.storageinfo.RepositoryStats;
import com.cognizant.collector.artifactory.beans.storageinfo.StorageInfo;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

public interface ArtifactoryClient {

    @GetMapping("/api/build")
    public BuildData getAllBuilds(@RequestHeader HttpHeaders headers);

    @GetMapping("/api/build{buildName}")
    public BuildRuns getBuildRuns(@RequestHeader HttpHeaders headers,
                                  @RequestParam("buildName") String buildName);

    @GetMapping("/api/build{buildName}{buildNumber}")
    public Build getBuildInfo(@RequestHeader HttpHeaders headers,
                              @RequestParam("buildName") String buildName,
                              @RequestParam("buildNumber") String buildNumber);

    @GetMapping("/api/storage/{repoKey}{folderPath}?stats")
    public RepositoryStats getFolderStats(@RequestHeader HttpHeaders headers,
                                          @RequestParam("repoKey") String repoKey,
                                          @RequestParam("folderPath") String folderPath);

    @GetMapping("/api/storage/{repoKey}{folderPath}")
    public RepositoryStats getFolderInfo(@RequestHeader HttpHeaders headers,
                                          @RequestParam("repoKey") String repoKey,
                                          @RequestParam("folderPath") String folderPath);

    @GetMapping("/api/storageinfo")
    public StorageInfo getStorageInfo(@RequestHeader HttpHeaders headers);

    @GetMapping("/api/search/artifact?name=.*&repos={repos}")
    public Artifacts getArtifacts(@RequestHeader HttpHeaders headers,
                                  @RequestParam("repos") String repo);

}
