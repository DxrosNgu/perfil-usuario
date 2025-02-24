package com.ec.pichincha.perfil.usuario.controller;

import com.ec.pichincha.perfil.usuario.model.dto.cliente.request.ActualizarClienteRequest;
import com.ec.pichincha.perfil.usuario.model.dto.cliente.response.ClienteActualizadoResponse;
import com.ec.pichincha.perfil.usuario.model.dto.cliente.response.ClienteBloqueadoResponse;
import com.ec.pichincha.perfil.usuario.model.dto.cliente.response.ClienteCreadoResponse;
import com.ec.pichincha.perfil.usuario.model.dto.cliente.response.ClienteResponse;
import com.ec.pichincha.perfil.usuario.model.dto.cliente.request.CrearClienteRequest;
import com.ec.pichincha.perfil.usuario.service.UsuarioService;
import com.ec.pichincha.perfil.usuario.util.exception.PersonaException;
import com.ec.pichincha.perfil.usuario.util.exception.UsuarioException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1/perfil-usuario/clientes")
@RequiredArgsConstructor
public class PerfilUsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping(path = "/{clienteId}")
    public @ResponseBody ResponseEntity<ClienteResponse> obtenerCliente(@PathVariable String clienteId) throws UsuarioException {
        return ResponseEntity.ok(usuarioService.obtenerUsuario(clienteId));
    }

    @PostMapping
    public @ResponseBody ResponseEntity<ClienteCreadoResponse> crearCliente(@RequestBody CrearClienteRequest cliente) {
        return ResponseEntity.ok(usuarioService.crearUsuario(cliente));
    }

    @PutMapping(path = "/{clienteId}")
    public ResponseEntity<ClienteActualizadoResponse> actualizarCliente(@PathVariable String clienteId, @RequestBody ActualizarClienteRequest cliente) throws UsuarioException {
        return ResponseEntity.ok(usuarioService.actualizarUsuario(clienteId, cliente));
    }

    @DeleteMapping(path = "/{clienteId}")
    public ResponseEntity<ClienteBloqueadoResponse> deleteCliente(String clienteId) throws UsuarioException {
       return ResponseEntity.ok(usuarioService.deleteUsuario(clienteId));
    }

}
