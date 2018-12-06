package com.springcloud.eurekahello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
/** @EnableEurekaClient 表明自己是一个eurekaclient  */
@EnableEurekaClient
public class EurekaHelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaHelloApplication.class, args);
    }
}
