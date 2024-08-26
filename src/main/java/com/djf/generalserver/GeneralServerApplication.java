package com.djf.generalserver;

import com.djf.generalserver.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class GeneralServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeneralServerApplication.class, args);
    }

}
