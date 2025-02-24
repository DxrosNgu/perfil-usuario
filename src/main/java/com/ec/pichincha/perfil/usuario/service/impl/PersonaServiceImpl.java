package com.ec.pichincha.perfil.usuario.service.impl;

import com.ec.pichincha.perfil.usuario.model.dto.persona.PersonaDto;
import com.ec.pichincha.perfil.usuario.model.entity.Persona;
import com.ec.pichincha.perfil.usuario.repository.PersonaRepository;
import com.ec.pichincha.perfil.usuario.service.PersonaService;
import com.ec.pichincha.perfil.usuario.util.constants.PrimaryKeyGenerator;
import com.ec.pichincha.perfil.usuario.util.exception.PersonaException;
import com.ec.pichincha.perfil.usuario.util.mapper.PersonaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;

    private final PersonaMapper personaMapper;

    @Override
    public Persona obtenerPersona(String personaId) throws PersonaException {
        return personaRepository.getPersonaByPersonaId(personaId)
                .orElseThrow(() -> new PersonaException("Persona no encontrada"));
    }

    @Override
    public PersonaDto crearpersona(Persona persona) {
        persona.setPersonaId(PrimaryKeyGenerator.generatePrimaryKey());
        var personaGuardada = personaRepository.save(persona);
        return personaMapper.mapPersonaDto(personaGuardada);
    }

    @Override
    public PersonaDto actualizarPersona(Persona persona) throws PersonaException {
        if (persona.getPersonaId() == null) throw new PersonaException("Persona no existente");

        var personaActualizada = personaRepository.save(persona);
        return personaMapper.mapPersonaDto(personaActualizada);
    }
}
