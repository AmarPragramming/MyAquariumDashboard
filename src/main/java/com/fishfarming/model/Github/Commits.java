package com.fishfarming.model.Github;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Commits {
    private String sha;
    //private CommitDetails commit;

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    // Getters and setters omitted for brevity
}

