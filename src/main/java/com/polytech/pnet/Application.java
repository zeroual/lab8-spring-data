package com.polytech.pnet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        // create  the application context from the configuration
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        // get the bean based with his id (by default is method name)
        PublicationService publicationService = applicationContext.getBean("publicationService", PublicationService.class);

        //use the publication service
        publicationService.post(new Post("Hi Polytech"));

    }

}
