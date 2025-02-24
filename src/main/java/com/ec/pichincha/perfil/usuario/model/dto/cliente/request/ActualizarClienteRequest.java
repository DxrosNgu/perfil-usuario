package com.ec.pichincha.perfil.usuario.model.dto.cliente.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ActualizarClienteRequest {

    private String genero;
    private Integer edad;
    private String direccion;
    private String telefono;
    private String contrasenia;
}
