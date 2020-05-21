package com.sykj.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 黄泉碧落
 * @date 2020/5/7 13:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String messges;
    private T  data;


    public  CommonResult (Integer code,String messges){
        this(code,messges,null);
    }

}
