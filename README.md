# tarea2_NoSQL_2022_objectdb


Para poder usar objecrdb primero es necesario descargarlo desde la pagina de objectdb
Para poder implementar objectdb en nuestro proyecto primero es necesario agregar el jar de object al proyecto.
En este caso usamos el ID inteliji.
Para agregar un jar en inteligi vamos a file/projectStructure, dentro del menu vamos a modules, dependencies y en icono de + click en JARS or Directories
Dentro seleccionar objectdb.jar
Una vez terminado es necesario configurar el pom.xml de nuestro proyecto agregando dependencias

Esta dependencia va antes de la etiqueta <dependencies>
<repositories>
  <repository>
    <id>objectdb</id>
    <name>ObjectDB Repository</name>
    <url>https://m2.objectdb.com</url>
  </repository>
</repositories>

Las siguientes van luego de <dependencies>
<dependency>
  <groupId>com.objectdb</groupId>
  <artifactId>objectdb</artifactId>
  <version>2.8.1</version>
</dependency>


<dependency>
<groupId>org.hibernate</groupId>
  <artifactId>hibernate-entitymanager</artifactId>
  <version>${hibernate.version}</version>
</dependency>


<dependency>
  <groupId>org.hibernate</groupId>
  <artifactId>hibernate-core</artifactId>
  <version>${hibernate.version}</version>
</dependency>


Por ultimo se crea un persistence.xml con la configuracion de la base
 
<?xml version="1.0" encoding="UTF-8"?>

<persistence xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/persistence" version="2.0">


<persistence-unit transaction-type="RESOURCE_LOCAL" name="objectdb">

<provider>com.objectdb.jpa.Provider</provider>

<properties>

  <property name="javax.persistence.jdbc.url" value="$objectdb/db/objectdb.odb"/>

  <property name="javax.persistence.jdbc.user" value="admin"/>

  <property name="javax.persistence.jdbc.password" value=""/>

  </properties>

  </persistence-unit>

</persistence>


{
	"info": {
		"_postman_id": "0c0ee8e5-02c3-454b-99e8-ff42886a599a",
		"name": "objectDB",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "24217384"
	},
	"item": [
		{
			"name": "http://localhost:8080/usuarios",
			"event": [
				{
					"listen": "test",
					"script": {
						"exec": [
							"pm.test(\"Body matches string\", function () {\r",
							"    pm.expect(pm.response.text()).to.include(\"prueba@prueba\");\r",
							"});\r",
							"pm.test(\"Body matches string\", function () {\r",
							"    pm.expect(pm.response.text()).to.include(\"nuevoUsuario\");\r",
							"});\r",
							"pm.test(\"Body matches string\", function () {\r",
							"    pm.expect(pm.response.text()).to.include(\"nuevo@nuevo\");\r",
							"});"
						],
						"type": "text/javascript"
					}
				}
			],
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"request": {
				"method": "GET",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/usuarios",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"usuarios"
					]
				}
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/usuarios/registrar",
			"event": [
				{
					"listen": "test",
					"script": {
						"exec": [
							"pm.test(\"Status code is 200\", function () {\r",
							"    pm.response.to.have.status(200);\r",
							"    pm.test(\"Ya existe usuario con ese mail\", function () {\r",
							"        pm.expect(pm.response.text()).to.include(\"error\", \"101\");\r",
							"    });\r",
							"});"
						],
						"type": "text/javascript"
					}
				}
			],
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": " {  \r\n    \"email\": \"diego@diego\",\r\n    \"nombre\": \"Diego\",\r\n    \"edad\": 28,\r\n    \"password\": \"123456\"\r\n }",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "localhost:8080/usuarios/registrar",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"usuarios",
						"registrar"
					]
				},
				"description": "Agrega un usuario"
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/planes",
			"event": [
				{
					"listen": "test",
					"script": {
						"exec": [
							"pm.test(\"Status code is 200\", function () {\r",
							"    pm.response.to.have.status(200);\r",
							"});"
						],
						"type": "text/javascript"
					}
				}
			],
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "localhost:8080/planes",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"planes"
					]
				}
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/usuarios/agregarplan/prueba@prueba/12",
			"event": [
				{
					"listen": "test",
					"script": {
						"exec": [
							"pm.test(\"Error no existe usuario\", function () {\r",
							"    pm.expect(pm.response.text()).to.include(\"No existe un usuario con ese email\");\r",
							"});\r",
							"pm.test(\"Ingresar plan a usuario correctamente\", function () {\r",
							"    pm.expect(pm.response.text()).to.include(\"OK\");\r",
							"});\r",
							"pm.test(\"Error no existe plan\", function () {\r",
							"    pm.expect(pm.response.text()).to.include(\"No existe un plan con ese id\");\r",
							"});"
						],
						"type": "text/javascript"
					}
				}
			],
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"request": {
				"method": "GET",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"email\": \"prueba@prueba\",\r\n    \"id\":1\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/usuarios/agregarplan/prueba@prueba/1",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"usuarios",
						"agregarplan",
						"prueba@prueba",
						"1"
					]
				}
			},
			"response": []
		},
		{
			"name": "localhost:8080/usuarios/iniciarsesion/a/4234234",
			"event": [
				{
					"listen": "test",
					"script": {
						"exec": [
							"pm.test(\"Body matches string\", function () {\r",
							"    pm.expect(pm.response.text()).to.include(\"true\");\r",
							"});\r",
							"\r",
							""
						],
						"type": "text/javascript"
					}
				}
			],
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "localhost:8080/usuarios/iniciarsesion/a/4234234",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"usuarios",
						"iniciarsesion",
						"a",
						"4234234"
					]
				}
			},
			"response": []
		},
		{
			"name": "localhost:8080/usuarios/registrar",
			"event": [
				{
					"listen": "test",
					"script": {
						"exec": [
							"pm.test(\"Body is correct\", function () {\r",
							"    pm.response.to.have.body({\"description\":\"Ya existe un usuario con ese mail\",\"error\":\"101\"});\r",
							"});\r",
							"\r",
							"pm.test(\"Status code is 200\", function () {\r",
							"    pm.response.to.have.status(200);\r",
							"});"
						],
						"type": "text/javascript"
					}
				}
			],
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": " {  \r\n    \"email\": \"a\",\r\n    \"nombre\": \"asdasdasd\",\r\n    \"edad\": 26,\r\n    \"password\": \"4234234\"\r\n }",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "localhost:8080/usuarios/registrar",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"usuarios",
						"registrar"
					]
				}
			},
			"response": []
		}
	]
}



