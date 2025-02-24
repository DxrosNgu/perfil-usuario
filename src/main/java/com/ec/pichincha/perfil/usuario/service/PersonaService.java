package com.ec.pichincha.perfil.usuario.service;

import com.ec.pichincha.perfil.usuario.model.dto.persona.PersonaDto;
import com.ec.pichincha.perfil.usuario.model.entity.Persona;
import com.ec.pichincha.perfil.usuario.util.exception.PersonaException;

public interface PersonaService {

    Persona obtenerPersona(String personaId) throws PersonaException;

    PersonaDto crearpersona(Persona persona);

    PersonaDto actualizarPersona(Persona persona) throws PersonaException;

}
