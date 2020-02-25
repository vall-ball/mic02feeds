package ru.vallball.mic02feeds.service;

import java.util.List;

import ru.vallball.mic02feeds.model.Feed;

public interface FeedService {

	void save(Feed feed);

	List<Feed> list();

	void delete(Long id);

	Feed findById(Long id);
}
