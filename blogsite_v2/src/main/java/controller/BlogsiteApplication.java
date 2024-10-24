package controller;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"model"})
@EnableJpaRepositories(basePackages = {"repository"})
@ComponentScan(basePackages = {"controller", "service"})


public class BlogsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogsiteApplication.class, args);
    }

}
