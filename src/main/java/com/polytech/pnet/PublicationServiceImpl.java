package com.polytech.pnet;

public class PublicationServiceImpl implements PublicationService {

    private PostRepository postRepository;

    public PublicationServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post post(Post post) {
        return postRepository.save(post);
    }
}
