package com.mazabel.forohub.domain.topico;

import com.mazabel.forohub.domain.enums.Status;


public record DatosListadoTopico(
        Long id,
        String titulo,
        String mensaje,
        String fechaCreacion,
        Status status,
        String autor,
        String curso
) {

    public DatosListadoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getFechaCreacion().toString(), topico.getStatus(),
                topico.getAutor(), topico.getCurso().toString()
                );
    }
}
