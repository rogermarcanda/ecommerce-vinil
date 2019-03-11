package br.com.ecommercevinil.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final Tag TAG_PRINCIPAL = new Tag("Disco", "Ações sobre disco de Vinil");
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.ecommercevinil"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .tags(TAG_PRINCIPAL, getTags());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Ecommerce Vinil API",
                "API Rest para o ecommerce  de vendas de vinil.",
                "0.1.0-SNAPSHOT",
                "Terms of service",
                new Contact("Luiz Rogerio Marcandalli", "", "rogermarcanda@gmail.com"),
                "MIT License",
                "LICENSE.md",
                Collections.emptyList());
    }

    private Tag[] getTags() {
        List<Tag> tags = new ArrayList<>();

        //adicionar tags adicionais
        tags.add(new Tag("Venda", "Ações sobre vendas de disco de vinil"));

        return tags.toArray(new Tag[tags.size()]);
    }

}
