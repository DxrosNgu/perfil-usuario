package com.ec.pichincha.perfil.usuario.service.impl;

import com.ec.pichincha.perfil.usuario.model.dto.cliente.ClienteDto;
import com.ec.pichincha.perfil.usuario.model.entity.Cliente;
import com.ec.pichincha.perfil.usuario.repository.ClienteRepository;
import com.ec.pichincha.perfil.usuario.service.ClienteService;
import com.ec.pichincha.perfil.usuario.util.constants.PrimaryKeyGenerator;
import com.ec.pichincha.perfil.usuario.util.exception.PersonaException;
import com.ec.pichincha.perfil.usuario.util.exception.UsuarioException;
import com.ec.pichincha.perfil.usuario.util.mapper.ClienteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteMapper clienteMapper;

    private final ClienteRepository clienteRepository;

    @Override
    public ClienteDto obtenerCliente(String clienteId) throws UsuarioException {
        var cliente = clienteRepository.getClienteByClienteId(clienteId)
                .orElseThrow(() -> new UsuarioException("Usuario no encontrado"));
        return clienteMapper.mapClienteDto(cliente);
    }

    @Override
    public ClienteDto crearCliente(Cliente cliente) {
        cliente.setClienteId(PrimaryKeyGenerator.generatePrimaryKey());
        Cliente clienteSave = clienteRepository.save(cliente);
        return clienteMapper.mapClienteDto(clienteSave);
    }

    @Override
    public ClienteDto actualizarCliente(Cliente cliente) throws PersonaException {
        if (cliente.getClienteId() == null) throw new PersonaException("Cliente no existente");
        Cliente clienteSave = clienteRepository.save(cliente);
        return clienteMapper.mapClienteDto(clienteSave);
    }

    @Override
    public ClienteDto deleteCliente(String clienteId) throws UsuarioException {
        var clienteDto = obtenerCliente(clienteId);
        clienteDto.setEstado(false);
        var cliente = clienteMapper.mapCliente(clienteDto);
        clienteRepository.save(cliente);
        return clienteDto;
    }
}
