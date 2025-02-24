-- Insert Personas
INSERT INTO PERSONA (persona_id, nombre, genero, edad, identificacion, direccion, telefono)
VALUES ('550e8400-e29b-41d4-a716-446655440000','Juan Perez', 'M', 30, '12345678', 'Calle Falsa 123', '555-1234');

INSERT INTO PERSONA (persona_id, nombre, genero, edad, identificacion, direccion, telefono)
VALUES ('330e8400-e29b-41d4-a716-223311430000','Maria Lopez', 'F', 25, '87654321', 'Avenida Siempre Viva 742', '555-5678');

-- Insert Clientes (linked to Persona)
INSERT INTO CLIENTE (cliente_id,persona_id, contrasenia, estado) VALUES ('550e8422-e29b-41d4-a716-446655440000','550e8400-e29b-41d4-a716-446655440000', 'password123', TRUE);
INSERT INTO CLIENTE (cliente_id, persona_id, contrasenia, estado) VALUES ('330e8422-e29b-41d4-a716-223311430000', '330e8400-e29b-41d4-a716-223311430000', 'securepass', TRUE);