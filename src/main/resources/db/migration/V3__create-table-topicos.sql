CREATE TABLE topicos (
    id BIGSERIAL PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    mensaje VARCHAR(100) NOT NULL,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(100) NOT NULL,
    usuario_id BIGINT NOT NULL,
    curso_id BIGINT NOT NULL,
    CONSTRAINT fk_topicos_usuario FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    CONSTRAINT fk_topicos_curso FOREIGN KEY (curso_id) REFERENCES cursos(id)
)