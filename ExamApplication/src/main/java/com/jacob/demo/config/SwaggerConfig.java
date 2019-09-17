package com.jacob.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//this class is importing swagger to help view valid endpoints 
//assuming you are running this app on port 8081, url for swagger is http://localhost:8080/swagger-ui.html#/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

@Bean
public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build();
}

}