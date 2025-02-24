package com.ec.pichincha.perfil.usuario.repository;

import com.ec.pichincha.perfil.usuario.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

    Optional<Cliente> getClienteByClienteId(String clienteId);
}
