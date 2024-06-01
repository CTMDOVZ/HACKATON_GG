package com.example.hackaton_gg.ENTIDAD_1;


import com.example.hackaton_gg.ENTIDAD_5.Playlist;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    private String nombre;
    private String email;
    private String password;
    private Date fechaDeRegistro;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Playlist> listasDeReproduccion;

    // Constructor sin argumentos
    public Usuario() {}

    // Constructor con id
    public Usuario(Long id) {
        this.idUser = id;
    }

    // Getters y Setters

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFechaDeRegistro() {
        return fechaDeRegistro;
    }

    public void setFechaDeRegistro(Date fechaDeRegistro) {
        this.fechaDeRegistro = fechaDeRegistro;
    }

    public List<Playlist> getListasDeReproduccion() {
        return listasDeReproduccion;
    }

    public void setListasDeReproduccion(List<Playlist> listasDeReproduccion) {
        this.listasDeReproduccion = listasDeReproduccion;
    }

    // ...
}
