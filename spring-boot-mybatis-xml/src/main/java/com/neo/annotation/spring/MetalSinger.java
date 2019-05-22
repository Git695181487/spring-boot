package com.neo.annotation.spring;

import org.springframework.stereotype.Component;

@Component // 加注解，让spring识别

//@Qualifier("metalSinger") bean的名称
public class MetalSinger implements Singer{

    @Override
    public String sing(String lyrics) {
        return "I am singing with DIO voice: "+lyrics;
    }
}