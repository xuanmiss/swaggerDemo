package com.miss.swagger_demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author miss
 * <p>
 * Created by miss on 2018/4/19
 */
@Data
public class User implements Serializable{

    private int id;
    private String name;
    private String pwd;
}
