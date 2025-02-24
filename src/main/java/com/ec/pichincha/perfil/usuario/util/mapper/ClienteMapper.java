package com.ec.pichincha.perfil.usuario.util.mapper;

import com.ec.pichincha.perfil.usuario.model.dto.cliente.ClienteDto;
import com.ec.pichincha.perfil.usuario.model.dto.cliente.request.ActualizarClienteRequest;
import com.ec.pichincha.perfil.usuario.model.dto.cliente.request.CrearClienteRequest;
import com.ec.pichincha.perfil.usuario.model.dto.persona.PersonaDto;
import com.ec.pichincha.perfil.usuario.model.entity.Cliente;
import com.ec.pichincha.perfil.usuario.model.entity.Persona;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface ClienteMapper {

    ClienteDto mapClienteDto(Cliente cliente);

    Cliente mapCliente(ClienteDto clienteDto);


    @Mapping(target = "persona.personaId", source = "personaId")
    Cliente mapCliente(CrearClienteRequest clienteRequest, String personaId);

    default Cliente mapCliente(ClienteDto clienteDto, ActualizarClienteRequest clienteRequest) {
        if (clienteRequest == null) {
            return null;
        }

        Cliente cliente = new Cliente();
        Persona persona = new Persona();
        PersonaDto clientePersona = clienteDto.getPersona();


        cliente.setClienteId(clienteDto.getClienteId());
        cliente.setEstado(clienteDto.getEstado());
        persona.setPersonaId(clientePersona.getPersonaId());
        persona.setNombre(clientePersona.getNombre());
        persona.setIdentificacion(clientePersona.getIdentificacion());

        cliente.setContrasenia(clienteRequest.getContrasenia() != null ? clienteRequest.getContrasenia() : clienteDto.getContrasenia());
        persona.setGenero(clienteRequest.getGenero() != null ? clienteRequest.getGenero() : clientePersona.getGenero());
        persona.setEdad(clienteRequest.getEdad() != null ? clienteRequest.getEdad() : clientePersona.getEdad());
        persona.setDireccion(clienteRequest.getDireccion() != null ? clienteRequest.getDireccion() : clientePersona.getDireccion());
        persona.setTelefono(clienteRequest.getTelefono() != null ? clienteRequest.getTelefono() : clientePersona.getTelefono());

        cliente.setPersona(persona);
        return cliente;
    }


}
