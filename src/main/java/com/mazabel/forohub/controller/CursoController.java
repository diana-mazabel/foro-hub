package com.mazabel.forohub.controller;

import com.mazabel.forohub.domain.curso.Curso;
import com.mazabel.forohub.domain.curso.CursoRepository;
import com.mazabel.forohub.domain.curso.DatosCurso;
import com.mazabel.forohub.domain.curso.DatosListadoCurso;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Limit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
