package com.bitso.interview.project.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TinyURL {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long tinyId;

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getTinyId() {
        return tinyId;
    }

    public void setTinyId(long id) {
        this.tinyId = id;
    }

}
