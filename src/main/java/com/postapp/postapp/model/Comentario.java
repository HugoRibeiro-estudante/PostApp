package com.postapp.postapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comentario {
    private Integer id ;
    private Postagem id_postagem;
    private Usuario id_usuario;
    private String comentario;
}
