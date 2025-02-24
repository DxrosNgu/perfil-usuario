package com.ec.pichincha.perfil.usuario.model.dto.cliente.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ClienteCreadoResponse {

    private final String respuesta = "Cliente creado exitosamente.";
    private String clienteId;
}
