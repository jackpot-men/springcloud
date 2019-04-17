package com.forlsz.controller;

import com.forlsz.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
    @Autowired
    HiService hiService;
    @GetMapping("/hiFeign")
            public String sayHi(@RequestParam(defaultValue = "lsz1",required = false) String name){
                return hiService.sayHi(name);
            }
}
