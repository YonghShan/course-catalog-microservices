package com.yonghshan.services.newuserapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class NewuserappApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewuserappApplication.class, args);
    }

}