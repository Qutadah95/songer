package com.example.songr.controller;

import com.example.songr.model.AlbumModel;
import com.example.songr.respository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
public class AlbumController {
@Autowired
    AlbumRepository albumRepository;
@GetMapping("/albums")
public String albums(Model model){
    AlbumModel album1=new AlbumModel("album1","Adel",1,1,"https://upload.wikimedia.org/wikipedia/en/1/1b/Adele_-_21.png");
    AlbumModel album2=new AlbumModel("album2","Rihanna",1,1,"https://upload.wikimedia.org/wikipedia/en/d/d1/Rihanna_-_Loud.png");
    AlbumModel album3=new AlbumModel("album3","sia",1,1,"https://i.pinimg.com/564x/0a/b9/3a/0ab93a940574edcb06814837533905d2.jpg");
    ArrayList<AlbumModel> album=new ArrayList<>();
    album.add(album1);
    album.add(album2);
    album.add(album3);
//    albumRepository.save(album1);
//    albumRepository.saveAll(album);
model.addAttribute("albums",albumRepository.findAll());
    return "album";
}
    @PostMapping("/addAlbum")
    public RedirectView addAlbum(AlbumModel album, Model model) {
        model.addAttribute("album",album);
        albumRepository.save(album);
        return new RedirectView("/albums");
    }
}
