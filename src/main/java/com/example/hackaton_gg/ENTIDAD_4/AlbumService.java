package com.example.hackaton_gg.ENTIDAD_4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public Album save(Album album) {
        return albumRepository.save(album);
    }

    public Optional<Album> findById(Long id) {
        return albumRepository.findById(id);
    }

    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    public void deleteById(Long id) {
        albumRepository.deleteById(id);
    }
}
