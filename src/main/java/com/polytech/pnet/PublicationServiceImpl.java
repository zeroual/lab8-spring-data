package com.polytech.pnet;

import org.springframework.stereotype.Component;

@Component
//@Service i prefer use @Service here because give the semantic that my Component is a service
public class PublicationServiceImpl implements PublicationService {

    private PostRepository postRepository;

    public PublicationServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post post(Post post) {
        return postRepository.save(post);
    }
}
