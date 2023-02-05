package com.fishfarming.controller;

import com.fishfarming.model.Github.Commits;
import com.fishfarming.service.GitRepoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fishfarming.service.InitialLoaderService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WelcomeController {

	@Autowired
	InitialLoaderService loaderService;

	@Autowired
	GitRepoServiceImpl gitRepoService;
	
	@GetMapping("/hi")
	public String sayHi(@RequestParam (required = false, name="user") String userName) {
		return "Hi there! "+userName;
	}

	@GetMapping("/repoCommits")
	public List<Commits> commitChecker(@RequestParam (required = false, name="branch") String branchName) {
		return gitRepoService.commitsInBranch(branchName);
	}

	@GetMapping("/loadData")
	public boolean loadData() {
		return loaderService.loadData();
	}

		
	}



