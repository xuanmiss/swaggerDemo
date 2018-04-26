package com.miss.swagger_demo.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author miss
 * <p>返回结果model
 * Created by miss on 2018/4/20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseInfo<T> {

    private String code;
    private String message;
    private T data;
}
