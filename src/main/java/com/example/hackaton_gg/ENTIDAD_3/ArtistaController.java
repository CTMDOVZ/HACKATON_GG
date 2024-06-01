package com.example.hackaton_gg.ENTIDAD_3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artistas")
public class ArtistaController {

    @Autowired
    private ArtistaService artistaService;

    @GetMapping
    public List<Artista> getAllArtistas() {
        return artistaService.findAll();
    }

    @PostMapping
    public Artista createArtista(@RequestBody Artista artista) {
        return artistaService.save(artista);
    }

    @GetMapping("/{id}")
    public Artista getArtistaById(@PathVariable Long id) {
        return artistaService.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Artista updateArtista(@PathVariable Long id, @RequestBody Artista artista) {
        artista.setId(id);
        return artistaService.save(artista);
    }

    @DeleteMapping("/{id}")
    public void deleteArtista(@PathVariable Long id) {
        artistaService.deleteById(id);
    }
}
