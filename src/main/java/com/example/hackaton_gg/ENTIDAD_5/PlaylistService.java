package com.example.hackaton_gg.ENTIDAD_5;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    public Playlist save(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    public Optional<Playlist> findById(Long id) {
        return playlistRepository.findById(id);
    }

    public List<Playlist> findAll() {
        return playlistRepository.findAll();
    }

    public void deleteById(Long id) {
        playlistRepository.deleteById(id);
    }

    public List<Playlist> findByUserId(Long userId) {
        return playlistRepository.findByUsuarioId(userId);
    }
}
