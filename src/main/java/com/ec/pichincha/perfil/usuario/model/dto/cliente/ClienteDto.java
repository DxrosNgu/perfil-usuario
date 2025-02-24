package com.ec.pichincha.perfil.usuario.model.dto.cliente;

import com.ec.pichincha.perfil.usuario.model.dto.persona.PersonaDto;
import com.ec.pichincha.perfil.usuario.model.entity.Persona;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClienteDto {

    private String clienteId;
    private PersonaDto persona;
    private String contrasenia;
    private Boolean estado;

}
