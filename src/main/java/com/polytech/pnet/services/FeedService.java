package com.polytech.pnet.services;

import com.polytech.pnet.models.Post;

import java.util.List;

public interface FeedService {

    List<Post> fetchFeeds();

    Post fetchFeed(Long id);
}
