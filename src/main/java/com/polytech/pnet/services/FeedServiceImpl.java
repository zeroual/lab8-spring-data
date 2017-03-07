package com.polytech.pnet.services;

import com.polytech.pnet.models.Post;
import com.polytech.pnet.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedServiceImpl implements FeedService {


    private PostRepository postRepository;

    @Autowired
    public FeedServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    public List<Post> fetchFeeds() {
        return postRepository.findAll();
    }

    public Post fetchFeed(Long id) {
        return postRepository.findOne(id);
    }
}
