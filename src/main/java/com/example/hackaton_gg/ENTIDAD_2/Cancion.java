package com.example.hackaton_gg.ENTIDAD_2;


import com.example.hackaton_gg.ENTIDAD_1.Usuario;
import com.example.hackaton_gg.ENTIDAD_3.Artista;
import com.example.hackaton_gg.ENTIDAD_4.Album;
import com.example.hackaton_gg.ENTIDAD_5.Playlist;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Cancion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSong;
    private String titulo;
    private int duracion;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artista artista;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Usuario usuario;

    @ManyToMany(mappedBy = "canciones")
    private List<Playlist> listasDeReproduccion;

    // Getters y Setters


    // ...
}
