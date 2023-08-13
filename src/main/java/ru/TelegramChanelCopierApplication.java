package ru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class TelegramChanelCopierApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelegramChanelCopierApplication.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
      //          .apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("ru.controllers"))
      //          .paths(PathSelectors.any())
                .paths(PathSelectors.ant("/api/*"))
                .build();
    }
}