package com.mazabel.forohub.domain.curso;

import com.mazabel.forohub.domain.enums.Categoria;

public record DatosCurso(
        String nombre,
        Categoria categoria) {
}
