package com.example.opentweet;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cloudinary.Cloudinary;

@SpringBootApplication
public class OpenTweetApplication {
	
	@Value("olufarai")
	private String cloudName;

	@Value("532355541363859")
	private String apiKey;

	@Value("mYNJ-hLKlecyE7Kclkj4yACc8uA")
	private String apiSecret;
	
	public static void main(String[] args) {
		SpringApplication.run(OpenTweetApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/feed").allowedOrigins("https://open-tweet-feed.herokuapp.com");
			}
		};
	}
	
	@Bean
	public Cloudinary cloudinaryConfig() {
		Cloudinary cloudinary = null;
		Map<String, String> config = new HashMap<String, String>();
		config.put("cloud_name", cloudName);
		config.put("api_key", apiKey);
		config.put("api_secret", apiSecret);
		cloudinary = new Cloudinary(config);
		return cloudinary;
	}

}
