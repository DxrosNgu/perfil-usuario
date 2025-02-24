package com.ec.pichincha.perfil.usuario.util.mapper;

import com.ec.pichincha.perfil.usuario.model.dto.cliente.request.ActualizarClienteRequest;
import com.ec.pichincha.perfil.usuario.model.dto.cliente.request.CrearClienteRequest;
import com.ec.pichincha.perfil.usuario.model.dto.persona.PersonaDto;
import com.ec.pichincha.perfil.usuario.model.entity.Persona;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface PersonaMapper {

    Persona mapPersona(PersonaDto personaDto);

    default Persona mapPersona(Persona existedPersona, ActualizarClienteRequest clienteRequest) {
        if ( clienteRequest == null ) {
            return existedPersona;
        }
//
//        if(clienteRequest.getPersonaId() != null) {
//            existedPersona.setPersonaId(clienteRequest.getPersonaId());
//        }

        if(clienteRequest.getGenero() != null) {
            existedPersona.setGenero(clienteRequest.getGenero());
        }

        if(clienteRequest.getEdad() != null) {
            existedPersona.setEdad(clienteRequest.getEdad());
        }

        if(clienteRequest.getDireccion() != null) {
            existedPersona.setDireccion(clienteRequest.getDireccion());
        }

        if(clienteRequest.getTelefono() != null) {
            existedPersona.setTelefono(clienteRequest.getTelefono());
        }

        return existedPersona;
    }


    PersonaDto mapPersonaDto( Persona persona);

    Persona mapPersona(CrearClienteRequest clienteRequest);

    Persona mapPersona(ActualizarClienteRequest clienteRequest);
}
