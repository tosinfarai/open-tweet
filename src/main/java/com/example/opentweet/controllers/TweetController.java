package com.example.opentweet.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.opentweet.entities.Tweet;
import com.example.opentweet.exceptions.ResourceNotFoundException;
import com.example.opentweet.repositories.TweetRepository;

@CrossOrigin(origins = {"https://open-tweet-feed.herokuapp.com"})
@RestController
@RequestMapping("/feed")
public class TweetController {
	
	@Autowired
	private TweetRepository tweetRepository;
	
	@GetMapping
	public List<Tweet> getTweets(){
		return tweetRepository.findAll();
	}
	
	@PostMapping
	public Tweet postTweet(@Valid @RequestBody Tweet tweet) {
		return tweetRepository.save(tweet);
	}
	
	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteTweet(@PathVariable(value = "id") Long tweetId)
			throws ResourceNotFoundException {
		Tweet tweet = tweetRepository.findById(tweetId)
				.orElseThrow(() -> new ResourceNotFoundException ("tweet does not exist"));
		
		tweetRepository.delete(tweet);
		Map<String, Boolean> response = new HashMap<>();
		response.put("tweet deleted", Boolean.TRUE);
		return response;
	}

}
