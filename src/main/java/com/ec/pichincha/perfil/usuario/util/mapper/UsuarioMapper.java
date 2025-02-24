package com.ec.pichincha.perfil.usuario.util.mapper;

import com.ec.pichincha.perfil.usuario.model.dto.cliente.ClienteDto;
import com.ec.pichincha.perfil.usuario.model.dto.cliente.response.ClienteActualizadoResponse;
import com.ec.pichincha.perfil.usuario.model.dto.cliente.response.ClienteBloqueadoResponse;
import com.ec.pichincha.perfil.usuario.model.dto.cliente.response.ClienteCreadoResponse;
import com.ec.pichincha.perfil.usuario.model.dto.cliente.response.ClienteResponse;
import com.ec.pichincha.perfil.usuario.model.dto.persona.PersonaDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface UsuarioMapper {

    @Mapping(target = "nombre" , source = "cliente.persona.nombre")
    @Mapping(target = "genero" , source = "cliente.persona.genero")
    @Mapping(target = "edad" , source = "cliente.persona.edad")
    @Mapping(target = "identificacion" , source = "cliente.persona.identificacion")
    @Mapping(target = "direccion" , source = "cliente.persona.direccion")
    @Mapping(target = "telefono" , source = "cliente.persona.telefono")
    ClienteResponse mapClienteResponse(ClienteDto cliente);

    ClienteCreadoResponse mapClienteCreadoResponse(ClienteDto cliente, PersonaDto personaDto);

    ClienteActualizadoResponse mapClienteActualizadoResponse(ClienteDto cliente);

    ClienteBloqueadoResponse mapClienteBloqueadoResponse(ClienteDto clienteDto);

}
