package com.fqy;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//eureka客户端
@EnableDiscoveryClient
//熔断降级
@EnableHystrix
//远程调用
@EnableFeignClients
public class SpringCloudShopCart {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudShopCart.class);
    }
}
