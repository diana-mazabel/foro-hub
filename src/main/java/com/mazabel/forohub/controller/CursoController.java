package com.mazabel.forohub.controller;

import com.mazabel.forohub.domain.curso.Curso;
import com.mazabel.forohub.domain.repository.CursoRepository;
import com.mazabel.forohub.domain.curso.DatosCurso;
import com.mazabel.forohub.domain.curso.DatosListadoCurso;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    CursoRepository repository;

    @GetMapping
    public ResponseEntity<List<DatosListadoCurso>> listadoCursos() {
        return ResponseEntity.ok(repository.findAll().stream().map(DatosListadoCurso::new).toList());
    }

    @PostMapping
    public ResponseEntity<DatosListadoCurso> registrarCurso(@RequestBody @Valid DatosCurso datosCurso) {
        Curso curso = repository.save(new Curso(datosCurso));
        URI url = UriComponentsBuilder.fromPath("/cursos/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(url).body(new DatosListadoCurso(curso));
    }
}
