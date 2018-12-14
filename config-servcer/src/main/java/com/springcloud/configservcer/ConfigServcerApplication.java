package com.springcloud.configservcer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
/** 开启配置服务器功能  */
@EnableConfigServer
public class ConfigServcerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServcerApplication.class, args);
    }

}

