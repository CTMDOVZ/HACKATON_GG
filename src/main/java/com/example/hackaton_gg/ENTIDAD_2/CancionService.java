package com.example.hackaton_gg.ENTIDAD_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CancionService {

    @Autowired
    private CancionRepository cancionRepository;

    public Cancion save(Cancion cancion) {
        return cancionRepository.save(cancion);
    }

    public Optional<Cancion> findById(Long id) {
        return cancionRepository.findById(id);
    }

    public List<Cancion> findAll() {
        return cancionRepository.findAll();
    }

    public void deleteById(Long id) {
        cancionRepository.deleteById(id);
    }
}
