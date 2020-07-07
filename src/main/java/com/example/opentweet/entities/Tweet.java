package com.example.opentweet.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table (name = "tweets")
public class Tweet {
	
	public Tweet() {
		
	}
	
	public Tweet(Long id, String name, String tweet) {
		super();
		this.id = id;
		this.name = name;
		this.tweet = tweet;
	}
	

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;

	@Column (name = "name", nullable = false)
	private String name;
	
	@Column (name = "tweet", nullable = false)
	@Size (max = 280, message = "What's happening?")
	private String tweet;

	
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

}
