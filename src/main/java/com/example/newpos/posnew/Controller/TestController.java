package com.example.newpos.posnew.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/test/")
@CrossOrigin
public class TestController {

    @GetMapping("methodOne")
    public String  myMethod(){
        System.out.println("this is the begining...");
        return "This is the begining";
    }
}
