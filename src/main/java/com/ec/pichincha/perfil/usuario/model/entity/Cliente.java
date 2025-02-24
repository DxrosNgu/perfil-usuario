package com.ec.pichincha.perfil.usuario.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @Column(name = "cliente_id")
    private String clienteId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "persona_id", nullable = false, unique = true)
    private Persona persona;

    private String contrasenia;

    private Boolean estado;
}
