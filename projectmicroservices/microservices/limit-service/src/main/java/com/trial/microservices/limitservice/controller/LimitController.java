package com.trial.microservices.limitservice.controller;

import java.io.File;
import java.io.FileInputStream;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trial.microservices.limitservice.bean.Limit;
import com.trial.microservices.limitservice.configuration.Configuration;

@RestController
public class LimitController {
	
	@Autowired
	private Configuration configuration;
	
	@Autowired
	private ResourceLoader resorceLoader;
	
	@RequestMapping("/limits")
	public Limit getLimits() {
		//return new Limit(1,1);
	
		return new Limit(configuration.getMin(), configuration.getMax());
	}

	@RequestMapping("/saveFile")
	public void readAndSaveFile() {
		ClassLoader classLoader = getClass().getClassLoader();
	    //File file = new File(classLoader.getResource("fileTest.txt").getFile());
	    //String data = FileUtils.readFileToString(file, "UTF-8");
	//	FileInputStream fis = new FileInputStream("src/test/resources/fileTest.txt");
	    //FileNew
	    
	}
}
