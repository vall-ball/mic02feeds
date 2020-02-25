package ru.vallball.mic02feeds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.vallball.mic02feeds.dao.FeedRepository;
import ru.vallball.mic02feeds.model.Feed;

@Service
@Transactional
public class FeedServiceImpl implements FeedService{

	@Autowired
	FeedRepository feedRepository;
	
	@Override
	public void save(Feed feed) {
		feedRepository.save(feed);
	}

	@Override
	public List<Feed> list() {
		return feedRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		feedRepository.deleteById(id);
	}

	@Override
	public Feed findById(Long id) {
		return feedRepository.findById(id).get();
	}

}
