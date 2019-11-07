package com.lzwind.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//标记自己是注册中心
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
