package com.example.songr.respository;

import com.example.songr.model.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song,Integer> {
    Iterable<Song> findAllByAlbumId(Integer id);

}
