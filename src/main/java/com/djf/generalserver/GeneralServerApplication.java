package com.djf.generalserver;

import com.djf.generalserver.config.RsaKeyProperties;
import com.djf.generalserver.model.Post;
import com.djf.generalserver.repository.PostRepository;
import com.djf.generalserver.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class GeneralServerApplication {
    private final RepositoryService repositoryService; // Injecting the repository

    // Constructor injection
    @Autowired
    public GeneralServerApplication(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }
    public static void main(String[] args) {
        SpringApplication.run(GeneralServerApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            // Your startup logic here
            System.out.println("Application started with command-line arguments: " + Arrays.toString(args));

            Post post = new Post("rad", "brohmassski");
            repositoryService.savePost(post);
            // You can also call services, repositories, etc. here
        };
    }
}
