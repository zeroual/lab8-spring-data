package com.polytech.pnet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public  PublicationService publicationService(){
        return new PublicationServiceImpl(postRepository());
    }

    @Bean
    public PostRepository postRepository(){
        return new MemoryPostRepository();
    }


}
