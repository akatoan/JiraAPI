package com.example.domain;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Repository
public class IssueInfo{

	private String baseUri;
	private String userId;
	private String password;
	
	private String projectKey;
	private String issueTypeId;
	private String summary;
	private String linkedIssueKey;
	
	
}