package com.mazabel.forohub.domain.usuario;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Entity(name = "Usuario")
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;
    @Email
    private String email;

}
