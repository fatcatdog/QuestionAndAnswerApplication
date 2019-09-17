This is a SpringBoot, Spring Security, JWT, JPA, and MySQL powered backend application.

I relied heavily on https://www.javainuse.com/spring/boot-jwt-mysql which is a Spring Security JWT tutorial to get my JWT/SpringSecurity set up. Feel free to browse this tutorial to quickly learn and set up a JWT environment.

Attached is a docker compose-compose.yml in the repo. Assuming you have Docker and Docker-Compose installed, all you need to do to test project is run: docker-compose up


Once application is running,


You should be able to hit: http://localhost:8080/swagger-ui.html#/ to view available rest end-points

If you try hit http://localhost:8080/question/all without registering for the application, Spring Security's filter will prevent you from accessing any of the endpoints aside from the swagger UI endpoints.

The application is designed to be used in the following way.

1. Our first step is to register with Spring Security. We will send a JSON object which includes a username and a password.

POST http://localhost:8080/register JSON

{
  "username": "usernameExample",
  "password": "userExamplePassword"
}

The REST response from application should include 200 OK:  

{
  "username": "usernameExample"
}

2. Now we will sign in to the application which will respond with a JWT token upon successful authentication.

POST http://localhost:8080/authenticate JSON

{
  "username": "usernameExample",
  "password": "userExamplePassword"
}

If the application is working, it should respond with:

{
    "token": "our example JWT token"
}

3. Copy token value, and try hit the following endpoint with your get request structured in the following way.


![Structure of your get request in Postman](/images/getAll.png)

GET http://localhost:8080/question/all JSON
In the Header of your request, attach an Authorization key with the value being "Bearer YOUR JWT TOKEN YOU COPIED PREVIOUSLY"

4. The application is designed to be a backend of a question and answer application. To attempt to answer a question.

POST http://localhost:8080/question/submit

Headers
Key: Authorization Value: Bearer JWT token
Key: Content-Type Value: application/json

Body

{
   "id": 1,
   "ask": "What is 10 + 15 + 12?",
   "answer": 37
}

This should response with 200 OK : Correct!!!!1
Any other answer aside from 37 would result in a 400 Not correct message.

5. The application allows users to attempt to answer any question in the question/all endpoint. The logic behind the answer revolves around the question id. If you browse the Swagger UI you can view other endpoints, such as adding questions.

Happy coding :)
