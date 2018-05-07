package com.miss.swagger_demo.utils;

/**
 * @author miss
 * <p>
 * Created by miss on 2018/4/27
 */
public class StringUtil {

    public static void main(String[] args)
    {
        String a = "1fs;sdf2;3sdf;4sdf";
        String b[] = a.split(";");
        String ns = "";
        for(String s:b)
        {
            ns = s;
            System.out.println(ns);
        }

    }
}
