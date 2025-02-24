package com.ec.pichincha.perfil.usuario.service;

import com.ec.pichincha.perfil.usuario.model.dto.cliente.ClienteDto;
import com.ec.pichincha.perfil.usuario.model.entity.Cliente;
import com.ec.pichincha.perfil.usuario.util.exception.PersonaException;
import com.ec.pichincha.perfil.usuario.util.exception.UsuarioException;

public interface ClienteService {

    ClienteDto obtenerCliente(String clienteId) throws UsuarioException;

    ClienteDto crearCliente(Cliente cliente);

    ClienteDto actualizarCliente(Cliente cliente) throws PersonaException;

    ClienteDto deleteCliente(String clienteId) throws UsuarioException;
}
