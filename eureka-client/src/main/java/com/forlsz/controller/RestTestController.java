package com.forlsz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTestController {
    @GetMapping("/testRest")
    public String testRest(){
        //RestTemplate 是用来消费 REST 服务的
        RestTemplate restTemplate = new RestTemplate();
        return  restTemplate.getForObject("https://www.baidu.com/",String.class);
    }
}
