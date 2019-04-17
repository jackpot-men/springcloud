package com.forlsz.controller;

import org.springframework.stereotype.Component;

@Component
public class HiHystrix implements EurekaClientFeign{

    public String sayHiFromClientEureka(String name){
        return "hi erro feign!"+name;
    }
}
