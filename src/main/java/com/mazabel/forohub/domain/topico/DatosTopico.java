package com.mazabel.forohub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        String usuario,
        @NotNull
        String curso
) {
}
