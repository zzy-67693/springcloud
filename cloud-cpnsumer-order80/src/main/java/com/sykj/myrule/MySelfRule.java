package com.sykj.myrule;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 黄泉碧落
 * @date 2020/5/10 14:11
 */
//@Configuration
//public class MySelfRule {
//
//    @Bean
//    public IRule  myRule(){
//       return  new RandomRule();//定义为随机
//
//    }
//}
