package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.IssueInfo;
import com.example.repository.IssueInfoRepository;
import com.example.repository.JiraOperationRepository;

@Service
public class CreateIssueService {
	
	@Autowired
	IssueInfoRepository issueInfoRepository;
	
	@Autowired
	JiraOperationRepository jiraOperationRepository;
	
	private String results;

	// Just display dummy message
	public String getItem() {
		return "GETメソッド成功!";
	}
	
	
	// Create a new issue
	public String createIssue(
			String linkedIssueKey
			)
	{	
		
		// get issue information from config.yaml
		IssueInfo issueInfo = issueInfoRepository.getIssueInfo(linkedIssueKey);
		
		// sent post request to JIRA restAPI to create an issue
		try {
			
			// get summary for the issueKey
			issueInfo = jiraOperationRepository.searchIssueAPI(issueInfo);
			
			// create an issue according to issueInfo
			results = jiraOperationRepository.createIssueAPI(issueInfo);
			
			System.out.println("New issue was created successfully： ");
			System.out.println(results);
			
		} catch (Exception e){
			System.out.println(e);		
		}
		
		return results;
	}
	

	
}