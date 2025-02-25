package com.mazabel.forohub.controller;

import com.mazabel.forohub.domain.usuario.DatosAuthenticationUsuario;
import com.mazabel.forohub.domain.usuario.Usuario;
import com.mazabel.forohub.infra.service.DatosTokenJWT;
import com.mazabel.forohub.infra.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> autenticarUsuario(@RequestBody @Valid DatosAuthenticationUsuario datosUsuario){

        try {
            var authToken = new UsernamePasswordAuthenticationToken(datosUsuario.username(), datosUsuario.password());
            var auth = authManager.authenticate(authToken);
            var JWTtoken = tokenService.generarToken((Usuario) auth.getPrincipal());;

            return ResponseEntity.ok(new DatosTokenJWT(JWTtoken));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o contraseña incorrectos");
        }
    }
}
