package com.mazabel.forohub.domain.repository;

import com.mazabel.forohub.domain.curso.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    //Curso findByNombre(String curso);
}
