package com.example.hackaton_gg.ENTIDAD_3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistaService {

    @Autowired
    private ArtistaRepository artistaRepository;

    public Artista save(Artista artista) {
        return artistaRepository.save(artista);
    }

    public Optional<Artista> findById(Long id) {
        return artistaRepository.findById(id);
    }

    public List<Artista> findAll() {
        return artistaRepository.findAll();
    }

    public void deleteById(Long id) {
        artistaRepository.deleteById(id);
    }
}
