package com.sykj.springcloud.controller;

import com.sykj.springcloud.entities.CommonResult;
import com.sykj.springcloud.entities.Payment;
import com.sykj.springcloud.lib.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author 黄泉碧落
 * @date 2020/5/7 15:47
 */
@RestController
@Slf4j
public class OrderController {
//    public static  final String PAYMENT_URL="http://localhost:8001";
public static  final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @Resource
     private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;


        @GetMapping("/consumer/payment/create")
        private CommonResult<Payment> create(Payment payment){

            return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
        }
        //返回对象为响应体中数据转化的对象
    //可以理解 为json
        @GetMapping("/consumer/payment/get/{pid}")
        public  CommonResult<Payment>getPyament(@PathVariable("pid") Integer pid){

            return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+pid,CommonResult.class);
        }

    /**
     *
     * @param pid
     * @return 返回对象为 ResponseEntity对象
     * 包含了响应体中的一些重要信息
     * 比如：响应头   响应状态码   响应体等
     * */
    @GetMapping("/consumer/payment/getForEntity/{pid}")
    public  CommonResult<Payment>getPyament2(@PathVariable("pid") Integer pid){

        ResponseEntity<CommonResult> Entity = restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+pid,CommonResult.class);

           if (Entity.getStatusCode().is2xxSuccessful()){

               log.info(Entity.getStatusCode()+"\t"+Entity.getHeaders());
               return Entity.getBody();
           }else {
               return  new CommonResult<>(444,"操作失败");
           }
    }
@GetMapping(value = "/consumer/payment/lb")
public  String getPaymentLB(){

    List<ServiceInstance>instances= discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

    if (instances==null || instances.size()<=0){
        return null;
    }

    ServiceInstance serviceInstance=loadBalancer.instance(instances);
    URI uri = serviceInstance.getUri();
    return restTemplate.getForObject(uri+"/payment/lb",String.class);
}


}
