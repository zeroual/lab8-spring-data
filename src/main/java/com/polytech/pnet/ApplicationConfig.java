package com.polytech.pnet;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(InfrastructureConfig.class)
@ComponentScan("com.polytech.pnet")
public class ApplicationConfig {

    /*
    @Bean
    public PublicationService publicationService(PostRepository postRepository) {
        return new PublicationServiceImpl(postRepository);
    }

    @Bean
    public PostRepository postRepository(DataSource dataSource) throws SQLException {
        return new JdbcPostRepository(dataSource.getConnection());
    }
    */

}
