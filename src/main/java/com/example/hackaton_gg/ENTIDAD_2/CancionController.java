package com.example.hackaton_gg.ENTIDAD_2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/canciones")
public class CancionController {

    @Autowired
    private CancionService cancionService;

    @GetMapping
    public List<Cancion> getAllCanciones() {
        return cancionService.findAll();
    }

    @PostMapping
    public Cancion createCancion(@RequestBody Cancion cancion) {
        return cancionService.save(cancion);
    }

    @PutMapping("/{id}")
    public Cancion updateCancion(@PathVariable Long id, @RequestBody Cancion cancion) {
        cancion.setId(id);
        return cancionService.save(cancion);
    }

    @DeleteMapping("/{id}")
    public void deleteCancion(@PathVariable Long id) {
        cancionService.deleteById(id);
    }
}
