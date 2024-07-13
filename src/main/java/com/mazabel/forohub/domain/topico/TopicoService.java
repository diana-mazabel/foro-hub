package com.mazabel.forohub.domain.topico;

import com.mazabel.forohub.domain.curso.Curso;
import com.mazabel.forohub.domain.curso.CursoRepository;
import com.mazabel.forohub.domain.usuario.Usuario;
import com.mazabel.forohub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    CursoRepository cursoRepository;

    public Usuario obtenerUsuario(DatosTopico datos){

        return usuarioRepository.findByNombreDeUsuario(datos.usuario());
    }

    public Curso obtenerCurso(DatosTopico datos) {
        return cursoRepository.findByNombre(datos.curso());
    }
}
