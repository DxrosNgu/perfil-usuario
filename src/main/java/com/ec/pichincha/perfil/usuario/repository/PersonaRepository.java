package com.ec.pichincha.perfil.usuario.repository;

import com.ec.pichincha.perfil.usuario.model.entity.Cliente;
import com.ec.pichincha.perfil.usuario.model.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, String> {

    Optional<Persona> getPersonaByPersonaId(String personaId);
}
