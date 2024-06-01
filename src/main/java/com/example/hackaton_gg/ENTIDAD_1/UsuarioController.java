package com.example.hackaton_gg.ENTIDAD_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/register")
    public Usuario register(@RequestBody Usuario usuario) {
        return usuarioService.register(usuario);
    }

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        // Implement login logic
        return "Login successful";
    }
}
