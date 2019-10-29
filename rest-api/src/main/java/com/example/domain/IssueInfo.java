package com.example.domain;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Repository
@Data
public class IssueInfo{

	private String baseUri;
	private String userId;
	private String password;
	private String sprintFieldName;
	
	private String projectKey;
	private String boardId;
	private String issueTypeId;
	private String summary;
	private String assignee;
	private String linkedIssueKey;
	private int activeSprintId;
		
}

