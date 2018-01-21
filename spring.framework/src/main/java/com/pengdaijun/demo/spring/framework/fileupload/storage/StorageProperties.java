package com.pengdaijun.demo.spring.framework.fileupload.storage;

import org.springframework.stereotype.Component;

//@ConfigurationProperties(value = "classpath:file_storage.properties", ignoreUnknownFields = false, prefix = "mail")
@Component
public class StorageProperties {

	/**
	 * Folder location for storing files
	 */
	private String location = "d:\\upload-dir";

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
