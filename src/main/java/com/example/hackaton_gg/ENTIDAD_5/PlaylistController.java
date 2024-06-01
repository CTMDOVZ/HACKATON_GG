package com.example.hackaton_gg.ENTIDAD_5;


import com.example.hackaton_gg.ENTIDAD_1.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @GetMapping("/users/{user_id}/playlists")
    public List<Playlist> getPlaylistsByUser(@PathVariable Long user_id) {
        return playlistService.findByUserId(user_id);
    }

    @GetMapping("/{playlist_id}")
    public Playlist getPlaylistById(@PathVariable Long playlist_id) {
        return playlistService.findById(playlist_id).orElse(null);
    }
    /*
    @PostMapping("/users/{user_id}/playlists")
    public Playlist createPlaylist(@PathVariable Long user_id, @RequestBody Playlist playlist) {
        // Implement logic to associate playlist with user
        playlist.setUsuario(new Usuario(user_id)); // Assumes Usuario has a constructor with id
        return playlistService.save(playlist);
    }

     */

    @PutMapping("/{playlist_id}")
    public Playlist updatePlaylist(@PathVariable Long playlist_id, @RequestBody Playlist playlist) {
        playlist.setId(playlist_id);
        return playlistService.save(playlist);
    }

    @DeleteMapping("/{playlist_id}")
    public void deletePlaylist(@PathVariable Long playlist_id) {
        playlistService.deleteById(playlist_id);
    }

}


