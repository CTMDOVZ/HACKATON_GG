package com.example.hackaton_gg.ENTIDAD_2;


import com.example.hackaton_gg.ENTIDAD_3.Artista;
import com.example.hackaton_gg.ENTIDAD_4.Album;
import com.example.hackaton_gg.ENTIDAD_5.Playlist;
import jakarta.persistence.*;
import java.util.List;

@Entity
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

    @ManyToMany(mappedBy = "canciones")
    private List<Playlist> listasDeReproduccion;

    // Getters y Setters

    public Long getIdSong() {
        return idSong;
    }

    public void setIdSong(Long idSong) {
        this.idSong = idSong;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public List<Playlist> getListasDeReproduccion() {
        return listasDeReproduccion;
    }

    public void setListasDeReproduccion(List<Playlist> listasDeReproduccion) {
        this.listasDeReproduccion = listasDeReproduccion;
    }

    // ...
}
