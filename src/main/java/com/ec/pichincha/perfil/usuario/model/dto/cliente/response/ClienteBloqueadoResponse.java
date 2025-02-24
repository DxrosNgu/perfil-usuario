package com.ec.pichincha.perfil.usuario.model.dto.cliente.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ClienteBloqueadoResponse {

    private final String respuesta = "Cliente actualizado exitosamente.";
    private String clienteId;
}
