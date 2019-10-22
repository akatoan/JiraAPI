package com.example.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.CreateIssueService;

@RestController
@RequestMapping(value = "api/create-issue/project/{projectKey}")
public class CreateIssueController {
	
	@Autowired
	CreateIssueService createIssueService;
	
    @GetMapping
    public String getItem() {
    	String msg = createIssueService.getItem();
    	return msg;
    }
    
    @PostMapping
    public String postItem(@PathVariable("projectKey") String projectKey) {
    	
    	String msg = createIssueService.postItem(projectKey);
    	return msg;
    }
    
}
