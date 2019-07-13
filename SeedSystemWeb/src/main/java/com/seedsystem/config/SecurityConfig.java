package com.seedsystem.config;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.seedsystem.common.exception.SeedSystemException;

/**
 * This class will provide the configuration required for Security.
 */

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Value("${allowedOrigins}")
	private String allowedOrigins;

	@Value("${allowedHeaders}")
	private String allowedHeaders;

	/**
	 * This method will enable httpSecurity and disable for HttpMethod.OPTIONS
	 * request and it will skip the path "/webjars/springfox-swagger-ui/**",
	 * "/swagger-ui.html", "/error", "/swagger-resources", "/swagger-resources/**",
	 * "/v2/api-docs", "/user/login".
	 * 
	 * @param http
	 *            httpSecurity
	 */

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		CorsConfigurationSource source = corsConfigurationSource();
		http.addFilterBefore(new CorsFilter(source), ChannelProcessingFilter.class);
		http.headers().httpStrictTransportSecurity().includeSubDomains(true).maxAgeInSeconds(3600);
		http.headers().xssProtection().disable();

		String[] excludePaths = { "/webjars/springfox-swagger-ui/**", "/configuration/ui", "/configuration/security",
				"/swagger-ui.html", "/error", "/swagger-resources", "/swagger-resources/**", "/v2/api-docs",
				"/user/login", "/user/register", "/version", "/users/passwords/forget-password" };

		http.csrf().disable().authorizeRequests().antMatchers(excludePaths).permitAll().antMatchers(HttpMethod.OPTIONS)
				.permitAll().antMatchers("/**/*").permitAll();
	}

	/**
	 * This method is use for cors Configuration.
	 * 
	 * @return source
	 */
	private CorsConfigurationSource corsConfigurationSource() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		if (allowedOrigins == null || allowedOrigins.isEmpty() || allowedHeaders == null || allowedHeaders.isEmpty()) {
			throw new SeedSystemException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong");
		}
		String[] origins = allowedOrigins.split(",");
		String[] headers = allowedHeaders.split(",");
		IntStream.range(0, origins.length).forEach(i -> {
			config.addAllowedOrigin(origins[i]);
		});
		IntStream.range(0, headers.length).forEach(i -> {
			config.addAllowedHeader(headers[i]);
		});
		config.addAllowedMethod("*");
		// more config
		source.registerCorsConfiguration("/**", config);
		return source;
	}
}
