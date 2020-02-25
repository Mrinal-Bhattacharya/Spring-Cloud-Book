package com.book.bookclient.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//@Profile("cloud")
@EnableDiscoveryClient
@Configuration
public class DiscoveryClient {
}
