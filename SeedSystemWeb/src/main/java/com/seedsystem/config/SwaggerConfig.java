package com.seedsystem.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This class will provide the configuration required for Swagger.
 *
 */
@Configuration
@EnableSwagger2

public class SwaggerConfig {

  @Value("${swagger.api.title}")
  private String apiTitle;

  @Value("${swagger.api.description}")
  private String apiDescription;

  @Value("${swagger.api.version}")
  private String apiVersion;

  @Value("${swagger.api.termOfServiceURL}")
  private String termOfServiceURL;

  @Value("${swagger.api.contact.name}")
  private String contactName;

  @Value("${swagger.api.contact.url}")
  private String contactURL;

  @Value("${swagger.api.contact.email}")
  private String contactEmail;

  @Value("${swagger.api.license}")
  private String apiLicense;

  @Value("${swagger.api.license.url}")
  private String apiLicenseURL;

  /**
   * This method is to create the Docket for Swagger API.
   *
   * @return docket {@link Docket}
   */
  @Bean
  public Docket productApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select().apis(RequestHandlerSelectors.basePackage("com.seedsystem.controller"))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(metaData());

  }

  /**
   * This method is to create the API Info.
   *
   * @return apiInfo {@link ApiInfo}
   */
  private ApiInfo metaData() {
    ApiInfo apiInfo = new ApiInfo(
        apiTitle,
        apiDescription,
        apiVersion,
        termOfServiceURL,
        new Contact(contactName, contactURL, contactEmail),
        apiLicense,
        apiLicenseURL);
    return apiInfo;
  }
}
