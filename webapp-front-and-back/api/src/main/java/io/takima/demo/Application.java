package io.takima.demo;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 */
@ComponentScan
@EnableJpaRepositories
@EnableAutoConfiguration
@SpringBootConfiguration
public class Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .run();
    }

}
