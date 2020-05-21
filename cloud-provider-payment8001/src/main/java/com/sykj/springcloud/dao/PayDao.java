package com.sykj.springcloud.dao;

import com.sykj.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 黄泉碧落
 * @date 2020/5/7 13:53
 */
@Mapper
public interface PayDao {


    public int create(Payment payment);


    public Payment getPaymentByid(@Param("pid") Integer pid);

}
