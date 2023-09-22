# EvaluacionNisumApiRestSpringBoot
Desarrollo para registrar usuarios en base de datos

PASOS:
1. se ejecuta el proyecto y se debe abrir 
   http://localhost:8094/swagger-ui/index.html#/usuario-controller/registrarUsuario
   
2. ejecutar la api /api/registro que es de tipo POST con el json de abajo
   {
  "id": 0,
  "name": "Marco Antonio Rebollo Lopez",
  "email": "marco.rebollo@rodriguez.org",
  "password": "hunter2",
  "created": "2023-09-21",
  "modified": "2023-09-21",
  "lastlogin": "2023-09-21",
  "isactive": "true",
  "phones": [
    {
      "id": 0,
      "number": "3015588457",
      "citycode": "1",
      "contrycode": "57"
    }
  ]
}
   

3. validar la creacion del usuario en la base de datos H2
   http://localhost:8094/h2-ui/login.jsp?jsessionid=3b1f4722073c7cf0737d083812eca35f
   
   

4. correr pruebas unitarias de la clase
   UserServiceTests


5. repositorio de git
   https://github.com/marcorebollo1980/EvaluacionNisumApiRestSpringBoot.git