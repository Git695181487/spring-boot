package com.neo.annotation.spring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary //Singer多个实现接口的时候默认使用该接口

//@Qualifier("operaSinger") bean的名称
public class OperaSinger implements Singer {
    @Override
    public String sing(String lyrics) {
        return "I am singing in Bocelli voice: "+lyrics;
    }
    
}