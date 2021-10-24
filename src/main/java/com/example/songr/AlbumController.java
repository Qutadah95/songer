package com.example.songr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;

@Controller
public class AlbumController {
@GetMapping("/albums")
public String albums(){

    AlbumModel album1=new AlbumModel("album1","Adel",1,1,"https://upload.wikimedia.org/wikipedia/en/1/1b/Adele_-_21.png");
    AlbumModel album2=new AlbumModel("album2","Rihanna",1,1,"https://upload.wikimedia.org/wikipedia/en/d/d1/Rihanna_-_Loud.png");
    AlbumModel album3=new AlbumModel("album3","sia",1,1,"https://i.pinimg.com/564x/0a/b9/3a/0ab93a940574edcb06814837533905d2.jpg");
    ArrayList<AlbumModel> album=new ArrayList<>();
    album.add(album1);
    album.add(album2);
    album.add(album3);


    return "album.html";
}
}
