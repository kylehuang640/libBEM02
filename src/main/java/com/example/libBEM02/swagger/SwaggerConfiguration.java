package com.example.libBEM02.swagger;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;


//setting up Authorization Bearer token for swagger
//there should be @SecurityRequirement(name = "Authorization") above every controller, if it is authenticated(in security config).
//@SecurityRequirement(name = "Authorization")
//or use Postman instead of Swagger, and after generating token, choose api you wanna go to, in Authorization choose "Bearer Token" and enter it in.
@SecurityScheme(
        name = "Authorization",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
@Configuration
public class SwaggerConfiguration {

}