package com.polytech.pnet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@Import(InfrastructureConfig.class)
public class ApplicationConfig {


    @Bean
    public PublicationService publicationService(PostRepository postRepository) {
        return new PublicationServiceImpl(postRepository);
    }

    @Bean
    public PostRepository postRepository(DataSource dataSource) throws SQLException {
        return new JdbcPostRepository(dataSource.getConnection());
    }


}
