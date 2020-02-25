package com.book.bookclient.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;

@RibbonClient(name = "book-server")
public class RibbonConfig {
    @Autowired
    IClientConfig ribbonClientConfig;

    @Bean
    public IPing ribbonPing(IClientConfig config) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>ribbonPing");
        return new PingUrl();
    }

    @Bean
    public IRule ribbonRule(IClientConfig config) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>ribbonRule");
        return new WeightedResponseTimeRule();
    }
}
