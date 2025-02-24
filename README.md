# Read Me First
The following was discovered as part of building this project:

* The original package name 'com.ec.pichincha.perfil-usuario' is invalid and this project uses 'com.ec.pichincha.perfil_usuario' instead.

# Creacion de usuario
<span style="color:red">
<h3>Recuerde guardar los id de los clientes generados</h3>
</span>

* Creacion de Usuario Jose Lema:
```
curl --location 'http://localhost:8080/v1/perfil-usuario/clientes' \
--header 'Content-Type: application/json' \
--data '{
"nombre": "Jose Lema",
"identificacion": "32094385",
"direccion": "Otavalo sn y principal",
"telefono": "098254785",
"contrasenia": "1234",
"estado": true
}'
```
* Creacion de Usuario Marianela Montalvo:
```
curl --location 'http://localhost:8080/v1/perfil-usuario/clientes' \
--header 'Content-Type: application/json' \
--data '{
"nombre": "Marianela Montalvo",
"identificacion": "45345465",
"direccion": "Amazonas y NNUU",
"telefono": "097548965",
"contrasenia": "5678",
"estado": true
}'
```
* Creacion de Usuario Juan Osorio:
```
curl --location 'http://localhost:8080/v1/perfil-usuario/clientes' \
--header 'Content-Type: application/json' \
--data '{
"nombre": "Juan Osorio",
"identificacion": "435346523",
"direccion": "13 junio y Equinoccial",
"telefono": "098874587",
"contrasenia": "1245",
"estado": true
}'
```

Note: Politicas de empresa Postman no se ha podido utilizar para el test tecnico.
Pero, aqui le dejamos pre-request script para crear el entorno de variable, para la creacion posterior de las cuentas:
```
if (pm.response && pm.response.json) {
let response = pm.response.json();
if (response.clienteId) {
pm.environment.set("clienteId", response.clienteId);
console.log("Cliente ID saved: " + response.clienteId);
} else {
console.log("Warning: clienteId not found in response");
}
} else {
console.log("Error: Response is not available or not in JSON format");
}
```