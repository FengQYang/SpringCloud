package com.fqy;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudPayApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudPayApplication.class);
    }
}
