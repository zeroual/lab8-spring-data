package com.polytech.pnet;

import java.util.List;

public interface PostRepository {
    Post save(Post post);

    List<Post> findAll();
}
