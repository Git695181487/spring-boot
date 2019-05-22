package com.neo.annotation.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SingerService {

    @Autowired
    private Singer singer;

    public String sing(){
        return singer.sing("song lyrics");
    }
    
    
//    @Autowired
//    private Singer singer;
//
//    @Qualifier("opreaSinger") //Singer 有多个实现类的时候优选使用opreaSinger的实现类里的方法
//    public String sing(){
//        return singer.sing("song lyrics");
//    }
    
}