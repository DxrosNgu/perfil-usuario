package com.ec.pichincha.perfil.usuario.model.dto.cliente.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ClienteActualizadoResponse {

    private final String respuesta = "Cliente actualizado exitosamente.";
    private String clienteId;
}
