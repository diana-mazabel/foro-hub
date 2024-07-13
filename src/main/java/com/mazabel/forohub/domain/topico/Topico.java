package com.mazabel.forohub.domain.topico;

import com.mazabel.forohub.domain.curso.Curso;
import com.mazabel.forohub.domain.enums.Status;
import com.mazabel.forohub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;
    @CreationTimestamp
    private LocalDateTime fechaCreacion;
    private Status status;

    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @JoinColumn(name = "curso_id")
    private  Curso curso;


    public Topico(DatosTopico datosTopico) {
        TopicoService ts = new TopicoService();
        this.titulo = datosTopico.titulo();
        this.mensaje = datosTopico.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.status = Status.SIN_RESOLVER;
        this.usuario = ts.obtenerUsuario(datosTopico);
        this.curso = ts.obtenerCurso(datosTopico);
    }

    public void actualizarInformacion(DatosActualizarTopico datosTopico) {
        if(datosTopico.titulo() != null) {
            this.titulo = datosTopico.titulo();
        }

        if(datosTopico.mensaje() != null) {
            this.mensaje = datosTopico.mensaje();
        }
    }

}
