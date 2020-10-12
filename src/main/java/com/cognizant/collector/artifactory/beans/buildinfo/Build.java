package com.cognizant.collector.artifactory.beans.buildinfo;

import lombok.Data;

import java.util.Date;
@Data
public class Build {
    private String uri;
    private Date lastStarted;
    private BuildInfo buildInfo;
}

