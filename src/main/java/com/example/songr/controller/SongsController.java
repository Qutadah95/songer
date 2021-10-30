package com.example.songr.controller;

import com.example.songr.model.AlbumModel;
import com.example.songr.model.Song;
import com.example.songr.respository.AlbumRepository;
import com.example.songr.respository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SongsController {
    @Autowired
    SongRepository songRepository;
    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/addsong/{id}")
    @ResponseBody
    public String addSong(@PathVariable int id){
        AlbumModel album= albumRepository.findById(id).get();
        Song song = new Song("song1",5,5,album);
        System.out.println(song);
        songRepository.save(song);
        return "addSongs";
    }
}