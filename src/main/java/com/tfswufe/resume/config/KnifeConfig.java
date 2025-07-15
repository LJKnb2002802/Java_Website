package com.tfswufe.resume.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Knife4jConfig
 * 注意：分组名称暂时只能使用英文或数字，在4.0.0~4.5.0的Knife4j版本中使用中文分组会出现页面访问异常
 * <p>
 * 特别注意：设置displayName后，knife4j.documents.name配置文档时，需使用displayName名称
 * <p>
 *
 */
@Configuration
public class KnifeConfig {
    /**
     * API
     * @return
     */
    @Bean
    public GroupedOpenApi apiApi() {
        return GroupedOpenApi.builder()
                .group("API模块")
                .packagesToScan("com.tfswufe.resume")
                .pathsToMatch("/**")
                .build();
    }


    /**
     * 接口信息
     */
    @Bean
    public OpenAPI apiInfo() {
        //作者信息
        final Contact contact = new Contact();
        contact.setName("梁云亮");
        contact.setUrl("http://www.hcshow.online");
        contact.setEmail("369950806@qq.com");

        final Info info = new Info()
                // 标题
                .title("智慧招聘")
                .summary("AI赋能，智慧招聘")
                // 版本
                .version("1.0.0")
                // 描述
                .description("AI智慧招聘")
                //设置接口文档的许可证信息
                .license(new License().name("Apache 2.0").url("http://www.resume.com/license"))
                //作者信息
                .contact(contact);

        final SecurityScheme securityScheme = new SecurityScheme().type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT");
        final Components components = new Components().addSecuritySchemes("Authorization", securityScheme);

        final ExternalDocumentation externalDocs = new ExternalDocumentation()
                .description("智慧招聘")
                .url("http://www.resume.com/docs");

        return new OpenAPI().components(components)
                .info(info)
                .externalDocs(externalDocs);
    }

}
