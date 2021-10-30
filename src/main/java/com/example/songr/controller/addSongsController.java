package com.example.songr.controller;

import com.example.songr.model.AlbumModel;
import com.example.songr.model.Song;
import com.example.songr.respository.AlbumRepository;
import com.example.songr.respository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class addSongsController {
    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    SongRepository songRepository;

    @GetMapping("/addsongforalbum")
    public String addSongForAlbum(@RequestParam Integer id, Model model) {
        AlbumModel album = albumRepository.findById(id).get();
        model.addAttribute("albumid", album.getId());
        return "addSongForm";
    }

    @PostMapping("/handlesongtoalbum")
    @ResponseBody
    public RedirectView handlesongtoalbum(@RequestParam String title, Integer trackNumber, Integer length,
                                          @RequestParam Integer id,
                                          Model model) {
        AlbumModel album = albumRepository.findById(id).get();
        Song song=new Song(title,length,trackNumber,album);
        songRepository.save(song);
        String url = "/showalbum?id=" + id;
        return new RedirectView(url);
    }

}