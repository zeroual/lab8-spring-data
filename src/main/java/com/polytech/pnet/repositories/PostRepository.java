package com.polytech.pnet.repositories;

import com.polytech.pnet.models.Post;

import java.util.List;

public interface PostRepository {
    Post save(Post post);

    List<Post> findAll();

    Post findOne(Long id);
}
