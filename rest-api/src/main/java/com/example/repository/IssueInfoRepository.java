
package com.example.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.Yaml;

import com.example.domain.IssueInfo;


@Repository
public class IssueInfoRepository {
	
	@Autowired
	IssueInfo issueInfo;
	
	public IssueInfo getIssueInfo(
    		String linkedIssueKey
    		)
    {
		
		DefaultResourceLoader resourceLoader;
		InputStreamReader reader;
		
		try {
		
			System.out.println("config,yamlを読込みます");
			
			// load config file
			resourceLoader = new DefaultResourceLoader();
			
			// 実行可能jarにして配布する場合
			Resource resource = resourceLoader.getResource("file:./config.yaml");
			// STS上で実行する場合
			//Resource resource = resourceLoader.getResource("config.yaml");
			
			reader = new InputStreamReader(resource.getInputStream());
			
			/*
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(
							ClassLoader.getSystemResourceAsStream("config.yaml")
							)
					);
			*/
			
			Yaml yaml = new Yaml();
			Map<String,Object> config = (Map)((Map)yaml.load(reader)).get("config");
			
			Map<String,Object> common = (Map)config.get("common");
			Map<String,Object> particular = (Map)config.get("particular");		
			
			System.out.println("config,yamlを読込みました");
			
			// set common parameter
			issueInfo.setBaseUri( common.get("baseUri").toString() );
			issueInfo.setUserId( common.get("userId").toString() );
			issueInfo.setPassword( common.get("password").toString() );
			
			// set particular parameter
			issueInfo.setProjectKey( particular.get("projectKey").toString() );
			issueInfo.setIssueTypeId( particular.get("issueTypeId").toString() );
			issueInfo.setSummary( particular.get("summary").toString() + linkedIssueKey );
			issueInfo.setLinkedIssueKey(linkedIssueKey);
		    	
			System.out.println(issueInfo);
		}
		catch(Exception e) {
			System.out.println(e);
		}
			
    	return issueInfo;
    	
    }
	
}
