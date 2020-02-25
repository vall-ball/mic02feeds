package ru.vallball.mic02feeds.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.vallball.mic02feeds.model.Feed;

public interface FeedRepository extends JpaRepository<Feed, Long>{

}
