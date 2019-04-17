package com.forlsz.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {
        @Autowired
        RestTemplate restTemplate;


        @HystrixCommand(fallbackMethod = "error1")
        public String hi(String name){
            return restTemplate.getForObject("http://eureka-client/hi?name="+name,String.class);
        }

        public String error1(String name){
            return "hi,,sorry,error!"+name;
        }
}
