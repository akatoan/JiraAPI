package com.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.CreateIssueService;

@RestController
@RequestMapping(value = "/api/create/issue/{linkedIssueKey}")
public class CreateIssueController {
	
	@Autowired
	CreateIssueService createIssueService;
    
	// No Trigger
    @GetMapping
    public String getItem() {
    	String msg = createIssueService.getItem();
    	return msg;
    }
    
    // Triggered by JIRA Webhook
    @PostMapping
    public String postItem(
    		@PathVariable("linkedIssueKey") String linkedIssueKey
    		)
    {
    	
    	String results = createIssueService.createIssue(linkedIssueKey);
    	
    	return results;
    }
    
}
