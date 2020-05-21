package com.sykj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 黄泉碧落
 * @date 2020/5/8 17:30
 */
@SpringBootApplication
@EnableEurekaServer
public class  EnrekaMain7002 {
    public static void main(String[] args) {
        SpringApplication.run(EnrekaMain7002.class,args);

    }
}
