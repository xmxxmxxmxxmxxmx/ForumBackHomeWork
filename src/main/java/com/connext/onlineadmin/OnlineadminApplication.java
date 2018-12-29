package com.connext.onlineadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OnlineadminApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineadminApplication.class, args);
    }

}

