package com.wehe.order;

import com.wehe.api.user.service.fallback.UserClientFallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients(basePackages = {"com.wehe.api.*"} )
@EnableDiscoveryClient
@SpringBootApplication
public class OrderApplication {

    @Bean
    public UserClientFallback userClientFallback(){
        return new UserClientFallback();
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class);
    }

}
