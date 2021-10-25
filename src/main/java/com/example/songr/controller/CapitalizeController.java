package com.example.songr.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CapitalizeController {
    @GetMapping("/capitalize/{word}")
    public String createCapitalize(Model model, @PathVariable String word){
        String lastString=word.toUpperCase();
        model.addAttribute("word",lastString);
        return "Capitalize";
    }
}