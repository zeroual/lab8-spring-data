package com.polytech.pnet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class Application {

    public static void main(String[] args) throws SQLException {

        System.setProperty("spring.profiles.active","DEV");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        // get the bean based with his id (by default is method name)
        PublicationService publicationService = applicationContext.getBean(PublicationService.class);

        //use the publication service
        publicationService.post(new Post("Hi Polytech"));

    }

}
