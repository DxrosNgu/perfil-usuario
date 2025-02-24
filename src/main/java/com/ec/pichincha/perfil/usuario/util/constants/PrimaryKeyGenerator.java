package com.ec.pichincha.perfil.usuario.util.constants;

import java.util.UUID;

public class PrimaryKeyGenerator {

    public static String generatePrimaryKey() {
        return UUID.randomUUID().toString();
    }
}
