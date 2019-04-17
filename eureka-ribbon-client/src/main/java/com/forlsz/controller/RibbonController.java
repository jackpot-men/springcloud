package com.forlsz.controller;

import com.forlsz.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonController {
    @Autowired
    RibbonService ribbonService;
    @GetMapping("/hiRibbon")
    public String hi(@RequestParam(required = false,defaultValue = "lsz1") String name){
        return ribbonService.hi(name);
    }
}
