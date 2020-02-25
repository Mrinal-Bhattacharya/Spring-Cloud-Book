package com.book.bookclient;

import com.book.bookclient.config.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableCircuitBreaker
@EnableDiscoveryClient
public class BookNonFeignClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookNonFeignClientApplication.class, args);
    }

}
