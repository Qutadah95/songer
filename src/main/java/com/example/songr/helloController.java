package com.example.songr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloController {
    @GetMapping("/hello")
    @ResponseBody
    public String helloController(){

        return "hello";
    }
}
