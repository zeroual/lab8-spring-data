package com.polytech.pnet;

import com.polytech.pnet.configs.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        // TODO we need to check that no profile is provided by params before set dev by default
        System.setProperty("spring.profiles.active", "DEV");
        SpringApplication.run(ApplicationConfig.class, args);
    }

}
