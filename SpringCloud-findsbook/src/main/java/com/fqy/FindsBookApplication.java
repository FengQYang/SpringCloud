package com.fqy;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FindsBookApplication {
    public static void main(String[] args) {
        SpringApplication.run(FindsBookApplication.class);
    }
}
