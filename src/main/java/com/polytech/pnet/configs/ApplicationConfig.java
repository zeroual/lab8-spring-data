package com.polytech.pnet.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(InfrastructureConfig.class)
@ComponentScan("com.polytech.pnet")
public class ApplicationConfig {


}
