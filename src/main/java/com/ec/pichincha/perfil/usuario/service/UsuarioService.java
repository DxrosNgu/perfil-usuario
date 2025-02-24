package com.ec.pichincha.perfil.usuario.service;

import com.ec.pichincha.perfil.usuario.model.dto.cliente.request.ActualizarClienteRequest;
import com.ec.pichincha.perfil.usuario.model.dto.cliente.request.CrearClienteRequest;
import com.ec.pichincha.perfil.usuario.model.dto.cliente.response.ClienteActualizadoResponse;
import com.ec.pichincha.perfil.usuario.model.dto.cliente.response.ClienteBloqueadoResponse;
import com.ec.pichincha.perfil.usuario.model.dto.cliente.response.ClienteCreadoResponse;
import com.ec.pichincha.perfil.usuario.model.dto.cliente.response.ClienteResponse;
import com.ec.pichincha.perfil.usuario.util.exception.PersonaException;
import com.ec.pichincha.perfil.usuario.util.exception.UsuarioException;

public interface UsuarioService {

    ClienteResponse obtenerUsuario(String clienteId) throws UsuarioException;

    ClienteCreadoResponse crearUsuario(CrearClienteRequest clienteRequest);

    ClienteActualizadoResponse actualizarUsuario(String clienteId, ActualizarClienteRequest clienteRequest) throws UsuarioException, PersonaException;

    ClienteBloqueadoResponse deleteUsuario(String clienteId) throws UsuarioException;
}
