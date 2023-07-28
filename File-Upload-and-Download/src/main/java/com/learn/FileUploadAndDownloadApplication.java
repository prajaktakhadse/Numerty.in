package com.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@SpringBootApplication
public class FileUploadAndDownloadApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileUploadAndDownloadApplication.class, args);
	    log.info("Download csv in springboot application satrted successfully");
	}

}
