package com.bitso.interview.project.domain;


import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateURL {

    @JsonProperty
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
