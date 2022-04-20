package com.bitso.interview.project.controller;


import com.bitso.interview.project.domain.CreateURL;
import com.bitso.interview.project.domain.TinyURL;
import com.bitso.interview.project.repository.TinyURLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Objects;

@RequestMapping("/create-url")
@RestController
public class TinyURLController {

    private TinyURLRepository tinyURLRepository;

    @Autowired
    public TinyURLController(TinyURLRepository tinyURLRepository) {
        this.tinyURLRepository = tinyURLRepository;
    }

    @PostMapping
    public ResponseEntity createUrl(@RequestBody CreateURL createURL) {

        if (Objects.nonNull(createURL) || isValidURI(createURL.getUrl())) {
            TinyURL tinyURL = new TinyURL();
            tinyURL.setUrl(createURL.getUrl());
            tinyURL = tinyURLRepository.save(tinyURL);

            return ResponseEntity.ok(tinyURL);
        }
        return ResponseEntity.badRequest().build();
    }

    public boolean isValidURI(String url) {

        try {
            URI.create(url);
            return true;
        } catch (IllegalArgumentException iae){
            return false;
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getTinyUrl(@PathVariable Long id) {
        return tinyURLRepository.findById(id).map(url ->
                ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY)
                .location(URI.create(url.getUrl()))
                .build()).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
