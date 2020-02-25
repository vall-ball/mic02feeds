package ru.vallball.mic02feeds.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ru.vallball.mic02feeds.model.Feed;
import ru.vallball.mic02feeds.service.FeedService;

@RestController
@RequestMapping(value = "/feeds", produces = "application/json")
public class FeedRestController {
	
	@Autowired
	FeedService feedService;
	
	@GetMapping
	@ResponseBody
	public List<Feed> list() {
		return feedService.list();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public Feed get(@PathVariable(value = "id") Long id) {
		return feedService.findById(id);
	}

	@PostMapping
	public ResponseEntity<Object> create(@Valid @RequestBody Feed feed) {
		feedService.save(feed);
		return new ResponseEntity<>("Feed is created successfully", HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody Feed feed) {
		try {
			Feed feedForUpdate = feedService.findById(id);
			feedForUpdate.setName(feed.getName());
			feedForUpdate.setSpecies(feed.getSpecies());
			feedForUpdate.setType(feed.getType());
			feedService.save(feedForUpdate);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>("Feed not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Feed is udated successfully", HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id) {
		try {
			feedService.delete(id);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>("Feed not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Feed is deleted successfully", HttpStatus.ACCEPTED);
	}


}
