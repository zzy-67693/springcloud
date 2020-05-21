package com.sykj.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 黄泉碧落
 * @date 2020/5/7 15:52
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    //@LoadBalanced//Ribbin负载工程
    public RestTemplate getRestTemplate(){
      return new RestTemplate();
    }
}
