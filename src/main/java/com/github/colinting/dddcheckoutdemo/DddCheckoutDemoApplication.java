package com.github.colinting.dddcheckoutdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DddCheckoutDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DddCheckoutDemoApplication.class, args);
    }

}
