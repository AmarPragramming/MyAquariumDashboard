package com.fishfarming.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fishfarming.model.Github.Commits;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class GitRepoServiceImpl {

    private String responseBody;

    public List<Commits> commitsInBranch(String branchName) {

        OkHttpClient client = new OkHttpClient();
        List<Commits> commitsList = null;
        //https://github.com/aravind06/SpringBootBasics/tree/Feature/HibernateSession

        final String UrlValue= "https://api.github.com/repos/aravind06/SpringBootBasics/commits?sha=Feature/HibernateSession";
        Request request = new Request.Builder().url(UrlValue).get().build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                System.out.println("Failed to get response from Github API");
                return null;
            }
           String responseBody = response.body().string();
            ObjectMapper objectMapper = new ObjectMapper();
            commitsList = objectMapper.readValue(responseBody, objectMapper.getTypeFactory().constructCollectionType(List.class, Commits.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return commitsList;
    }

}
