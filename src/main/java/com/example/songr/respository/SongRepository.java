package com.example.songr.respository;

import com.example.songr.model.AlbumModel;
import com.example.songr.model.Song;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SongRepository extends CrudRepository<Song,Integer> {
    public List<Song> findByTitleAndAlbum(String title, AlbumModel albumSong);
}
