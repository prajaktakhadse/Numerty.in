package com.learn.upload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileUploadResponse {
	
	private long id;

	private String fileName;
	
	private String downloadUri;
	
	private long size;
}
