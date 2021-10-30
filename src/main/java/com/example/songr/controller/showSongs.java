package com.example.songr.controller;

import com.example.songr.respository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class showSongs {
    @Autowired
    SongRepository songRepository;

    @GetMapping("/songs")
    public String showAllSongs(Model model){
        model.addAttribute("songs",songRepository.findAll());
        return "showesSongs";
    }
}
