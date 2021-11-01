package com.example.songr.respository;

import com.example.songr.model.AlbumModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends CrudRepository<AlbumModel,Integer> {
    public List<AlbumModel> findByTitle(String albumSong);
}
