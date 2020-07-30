package com.example.opentweet.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table (name = "tweets")
public class Tweet {
	
	public Tweet() {
		
	}
	
	public Tweet(Long id, String name, String tweet, LocalDateTime dateTime, String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.tweet = tweet;
		this.dateTime = dateTime;
		this.imageUrl = imageUrl;
	}
	

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;

	@Column (name = "name", nullable = false)
	private String name;
	
	@Column (name = "tweet", nullable = false)
	@Size (max = 280, message = "Cannot exceed 280 characters")
	private String tweet;
	
	@Column(name = "date_time", updatable=false)
	@CreationTimestamp
	private LocalDateTime dateTime;
	
	@Column(name = "image_url")
	private String imageUrl;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTweet() {
		return tweet;
	}

	public void setTweet(String tweet) {
		this.tweet = tweet;
	}
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

}
