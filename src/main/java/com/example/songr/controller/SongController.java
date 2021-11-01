package com.example.songr.controller;
import com.example.songr.model.AlbumModel;
import com.example.songr.model.Song;
import com.example.songr.respository.AlbumRepository;
import com.example.songr.respository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class SongController {
    @Autowired
    SongRepository SongRepository;
    @Autowired
    AlbumRepository albumRepositories;
    @GetMapping("/addSongs/{id}")
    public String getAllSong(@PathVariable Integer id, Model model){
        AlbumModel album = albumRepositories.findById(id).get();
        model.addAttribute("album", album);
        return "addSongs";
    }

    @PostMapping("/addSongs/addSong/")
    public RedirectView addSong(String title , int length, int trackNumber, String album){
        List<AlbumModel> songAlbum = albumRepositories.findByTitle(album);
        Song newSong = new Song(title, length, trackNumber, songAlbum.get(0));
        SongRepository.save(newSong);
        List<Song> song = SongRepository.findByTitleAndAlbum(
                newSong.getTitle(),
                newSong.getAlbum()
        );
        return new RedirectView("/addSongs/" + song.get(0).getAlbum().getId());


    }

}
