package com.ec.pichincha.perfil.usuario.service.impl;

import com.ec.pichincha.perfil.usuario.model.dto.cliente.ClienteDto;
import com.ec.pichincha.perfil.usuario.model.dto.cliente.request.ActualizarClienteRequest;
import com.ec.pichincha.perfil.usuario.model.dto.cliente.request.CrearClienteRequest;
import com.ec.pichincha.perfil.usuario.model.dto.cliente.response.ClienteActualizadoResponse;
import com.ec.pichincha.perfil.usuario.model.dto.cliente.response.ClienteBloqueadoResponse;
import com.ec.pichincha.perfil.usuario.model.dto.cliente.response.ClienteCreadoResponse;
import com.ec.pichincha.perfil.usuario.model.dto.cliente.response.ClienteResponse;
import com.ec.pichincha.perfil.usuario.model.dto.persona.PersonaDto;
import com.ec.pichincha.perfil.usuario.service.ClienteService;
import com.ec.pichincha.perfil.usuario.service.PersonaService;
import com.ec.pichincha.perfil.usuario.service.UsuarioService;
import com.ec.pichincha.perfil.usuario.util.exception.PersonaException;
import com.ec.pichincha.perfil.usuario.util.exception.UsuarioException;
import com.ec.pichincha.perfil.usuario.util.mapper.ClienteMapper;
import com.ec.pichincha.perfil.usuario.util.mapper.PersonaMapper;
import com.ec.pichincha.perfil.usuario.util.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final ClienteService clienteService;
    private final PersonaService personaService;
    private final ClienteMapper clienteMapper;
    private final PersonaMapper personaMapper;
    private final UsuarioMapper usuarioMapper;

    @Override
    public ClienteResponse obtenerUsuario(String clienteId) throws UsuarioException {
        var clienteDto = clienteService.obtenerCliente(clienteId);
        return usuarioMapper.mapClienteResponse(clienteDto);
    }

    @Override
    public ClienteCreadoResponse crearUsuario(CrearClienteRequest clienteRequest) {
        var persona  = personaMapper.mapPersona(clienteRequest);
        PersonaDto personaDto = personaService.crearpersona(persona);

        var cliente  = clienteMapper.mapCliente(clienteRequest, personaDto.getPersonaId());
        ClienteDto clienteDto = clienteService.crearCliente(cliente);

        return usuarioMapper.mapClienteCreadoResponse(clienteDto, personaDto);
    }

    @Override
    public ClienteActualizadoResponse actualizarUsuario(String clienteId, ActualizarClienteRequest clienteRequest) throws UsuarioException {
        ClienteDto clienteExistente = clienteService.obtenerCliente(clienteId);

        var cliente  = clienteMapper.mapCliente(clienteExistente, clienteRequest);
        personaService.actualizarPersona(cliente.getPersona());
        ClienteDto clienteActualizado = clienteService.actualizarCliente(cliente);

        return usuarioMapper.mapClienteActualizadoResponse(clienteActualizado);
    }

    @Override
    public ClienteBloqueadoResponse deleteUsuario(String clienteId) throws UsuarioException {
        var clienteDto = clienteService.deleteCliente(clienteId);
        return usuarioMapper.mapClienteBloqueadoResponse(clienteDto);
    }
}
