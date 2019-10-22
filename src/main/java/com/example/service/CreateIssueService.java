package com.example.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateIssueService {
	
	public String getItem() {	
		return "GETメソッド成功!";
	}
	
	public String postItem(String projectKey) {
		return "POSTメソッド成功!" + projectKey ;
	}
	
}
