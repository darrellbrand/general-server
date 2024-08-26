package com.djf.generalserver;

import com.djf.generalserver.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories("com.djf.generalserver.repository")
@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class GeneralServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeneralServerApplication.class, args);
    }

}
