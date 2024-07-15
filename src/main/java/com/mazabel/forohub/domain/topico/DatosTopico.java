package com.mazabel.forohub.domain.topico;

import com.mazabel.forohub.domain.enums.Curso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        String autor,
        @NotNull
        Curso curso
) {
}
