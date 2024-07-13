package com.mazabel.forohub.domain.curso;

import com.mazabel.forohub.domain.enums.Categoria;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Curso")
@Table(name = "cursos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;


    public Curso(DatosCurso curso) {
        this.nombre = curso.nombre();
        this.categoria = curso.categoria();
    }
}
