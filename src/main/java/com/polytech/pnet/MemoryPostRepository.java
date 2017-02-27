package com.polytech.pnet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MemoryPostRepository implements PostRepository {

    private Set<Post> database = new HashSet();

    public Post save(Post post) {
        database.add(post);
        return post;
    }

    public List<Post> findAll() {
        return new ArrayList<Post>(database);
    }
}
