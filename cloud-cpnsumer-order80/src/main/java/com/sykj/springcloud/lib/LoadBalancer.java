package com.sykj.springcloud.lib;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalancer {

    /**
     * 负载算法
     */
          ServiceInstance instance(List<ServiceInstance>serviceInstances);

}
