
![image](https://github.com/user-attachments/assets/5769e11b-111e-49ec-bf7e-bb2db290f38e)

Este proyecto es una **API REST** desarrollada en **Spring Boot** para la gestión de tareas. Utiliza un enfoque modular que incluye **controladores**, **servicios, DAOs, y entidades,** 
facilitando una arquitectura limpia y escalable. El sistema permite la creación, actualización, eliminación y consulta de tareas, integrando conceptos como mapeo de 
objetos con** ModelMapper**, y manejo de estados.

La aplicación está diseñada para interactuar con bases de datos relacionales como MySQL o PostgreSQL, siguiendo las mejores prácticas de persistencia y transferencia de datos. 
La conversión de Payloads a Entities y su posterior transformación en DTOs permite garantizar una gestión eficiente de la información y un control preciso sobre los datos 
expuestos al cliente.


__________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________


**Payload**

El Payload es el objeto que contiene los datos enviados desde el cliente hacia nuestro backend. Estos datos provienen de herramientas como Postman o de un frontend desarrollado en React, y son enviados al controlador en una operación de tipo HTTP como POST. El controlador recibe este Payload y lo utiliza para transferir la información al servicio correspondiente. El Payload puede contener datos como name, lastName, entre otros, y es validado antes de ser procesado.

______________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________

**Entity**


La Entity es el objeto que representa una tabla en la base de datos y contiene todos los campos necesarios para modelar los datos persistentes. En el servicio, el Payload recibido es convertido en una Entity mediante herramientas como ModelMapper. Esta entidad se utiliza para interactuar con el DAO (Data Access Object) o el repositorio correspondiente, donde se realiza la persistencia en la base de datos, ya sea MySQL, PostgreSQL u otra. Una vez persistido el objeto, el servicio transforma la Entity de nuevo en un DTO para devolver una respuesta controlada al cliente, incluyendo información sobre la creación, actualización o estado del objeto guardado.


______________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________


**DTO (Data Transfer Object)**

El DTO (Objeto de Transferencia de Datos) es una representación simplificada de la entidad, diseñada para transferir solo los datos necesarios entre capas de la aplicación. Tras la persistencia en la base de datos, el servicio transforma la Entity en un DTO para devolver la información relevante al cliente, ocultando campos que no son necesarios, como password o updateDate, y mostrando solo aquellos que el cliente necesita, como name o lastName. Este proceso es facilitado por anotaciones como @Builder, que permiten construir fácilmente el objeto DTO.



______________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________

**ModelMapper**

ModelMapper es una biblioteca que facilita la conversión de objetos en aplicaciones Java. Su principal función es mapear automáticamente entre dos objetos, usualmente entre entidades del dominio (Entity) y objetos de transferencia de datos (DTO) o Payloads. Esto es especialmente útil cuando necesitas transferir datos entre las distintas capas de la aplicación, evitando realizar conversiones manuales repetitivas.

En el flujo típico de una aplicación, cuando el controlador recibe un Payload (datos enviados por el cliente), este es convertido a una Entity mediante ModelMapper para que pueda ser procesado y persistido en la base de datos. Del mismo modo, cuando una Entity es recuperada de la base de datos, ModelMapper convierte dicha Entity a un DTO para enviar al cliente únicamente los datos relevantes.


______________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________

**LAS FLECHAS VERDES SON EL FLUJO DE LA INFO QUE INGRESA **|| **LAS FLECHAS ROJAS SON EL FLUJO DE LA INFO QUE SE RETORNA**

![image](https://github.com/user-attachments/assets/71d086a6-1a24-4d69-b10a-3782e1c90cfd)



______________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________

**SOFTWARE DEPLOYMENT**

![image](https://github.com/user-attachments/assets/63920ecf-125c-4313-bac0-6c0dd666b863)

