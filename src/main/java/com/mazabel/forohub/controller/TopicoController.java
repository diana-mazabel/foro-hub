package com.mazabel.forohub.controller;

import com.mazabel.forohub.domain.repository.TopicoRepository;
import com.mazabel.forohub.domain.topico.DatosActualizarTopico;
import com.mazabel.forohub.domain.topico.DatosListadoTopico;
import com.mazabel.forohub.domain.topico.DatosTopico;
import com.mazabel.forohub.domain.topico.Topico;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;


    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> datosListaTopicos(@PageableDefault(size = 5, sort = {"curso"}) Pageable pageable) {
        var page = topicoRepository.findAll(pageable).map(DatosListadoTopico::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detallarTopico(@PathVariable Long id) {
        var topico = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosListadoTopico(topico));
    }

    @PostMapping
    public ResponseEntity registrarTopico(@RequestBody @Valid DatosTopico datosTopico, UriComponentsBuilder uriComponentsBuilder) {
        var topico = new Topico(datosTopico);
        topicoRepository.save(topico);

        URI url = UriComponentsBuilder.fromPath("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(new DatosListadoTopico(topico));
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        var topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarInformacion(datosActualizarTopico);
        return ResponseEntity.ok(new DatosListadoTopico(topico));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity marcarTopicoResuelto(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topico.topicoResuelto();
        return ResponseEntity.ok(new DatosListadoTopico(topico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.findById(id).orElse(null);
        if (topico == null) {
            return ResponseEntity.noContent().build();
        }
        topicoRepository.delete(topico);
        return ResponseEntity.noContent().build();
    }



}
