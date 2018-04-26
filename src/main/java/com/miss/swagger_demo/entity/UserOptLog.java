package com.miss.swagger_demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author miss
 * <p>
 * Created by miss on 2018/4/20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOptLog implements Serializable{

    private int id;
    private String user;
    private Date time;
    private String content;
}
