package com.skillstorm.services;

public class URLParserService {
	public String extractRequestFromURL(String url) {
		if (url != null) {
			String[] splitString = url.split("/"); // [12, 123]
			
			return splitString[1]; // Throws an exception if this isn't a int	
		}
		return null;
	}
}
