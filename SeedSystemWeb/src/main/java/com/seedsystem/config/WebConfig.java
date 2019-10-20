package com.seedsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.seedsystem.interceptor.AuthenticationInterceptor;


/**
 */
@Configuration
@EnableWebMvc
@EnableAsync
public class WebConfig implements WebMvcConfigurer {

  @Autowired
  private AuthenticationInterceptor authenticationInterceptor;


  /**
   * This method is used to define the interceptors.
   *
   * @param registry
   *          {@link InterceptorRegistry}
   */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    String[] excludePaths = {"/webjars/springfox-swagger-ui/**", "/swagger-ui.html", "/error",
        "/swagger-resources", "/swagger-resources/**", "/v2/api-docs", "/user/login","/user/test","/user/register", "/version","/search/test","/search/dealer"};
    registry.addInterceptor(authenticationInterceptor).addPathPatterns("/**")
        .excludePathPatterns(excludePaths);
  }

  /**
   * This method is used to add path for Swagger resources.
   *
   * @param registry
   *          {@link ResourceHandlerRegistry}
   */
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("swagger-ui.html")
        .addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
    registry.addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");

  }

}
