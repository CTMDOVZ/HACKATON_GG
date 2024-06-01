package com.example.hackaton_gg.Auth;

import com.example.hackaton_gg.Auth.Dto.AuthJwtResponse;
import com.example.hackaton_gg.Auth.Dto.AuthLoginRequest;
import com.example.hackaton_gg.Auth.Dto.AuthRegisterRequest;
import com.example.hackaton_gg.Exceptions.UserAlreadyExistException;
import com.example.hackaton_gg.Exceptions.IllegalArgumentException;
import com.example.hackaton_gg.Exceptions.UsernameNotFoundException;
import com.example.hackaton_gg.ENTIDAD_1.Role;
import com.example.hackaton_gg.ENTIDAD_1.Usuario;
import com.example.hackaton_gg.ENTIDAD_1.UsuarioRepository;
import com.example.hackaton_gg.Config.JwtService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthService {

    final UsuarioRepository userRepository;
    final JwtService jwtService;
    final PasswordEncoder passwordEncoder;
    final ModelMapper modelMapper;

    @Autowired
    public AuthService(UsuarioRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }


    public AuthJwtResponse login(AuthLoginRequest req) {
        Optional<Usuario> user = userRepository.findByEmail(req.getEmail());

        if (user.isEmpty()) throw new UsernameNotFoundException("Email is not registered");

        if (!passwordEncoder.matches(req.getPassword(), user.get().getPassword()))
            throw new IllegalArgumentException("Password is incorrect");

        AuthJwtResponse response = new AuthJwtResponse();

        response.setToken(jwtService.generateToken(user.get()));
        return response;
    }

    public AuthJwtResponse register(AuthRegisterRequest req) {
        Optional<Usuario> user = userRepository.findByEmail(req.getEmail());
        if (user.isPresent()) throw new UserAlreadyExistException("Email is already registered");

        Usuario newUser = modelMapper.map(req, Usuario.class);
        newUser.setPassword(passwordEncoder.encode(req.getPassword()));
        //newUser.setCreatedAt(LocalDateTime.now());

        if(req.getIsAdmin()) newUser.setRole(Role.ADMIN);
        else newUser.setRole(Role.USER);

        userRepository.save(newUser);

        AuthJwtResponse response = new AuthJwtResponse();
        response.setToken(jwtService.generateToken(newUser));
        return response;
    }

}
