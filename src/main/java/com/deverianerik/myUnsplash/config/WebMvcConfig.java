package com.deverianerik.myUnsplash.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	
	@Override
	public void addCorsMappings(CorsRegistry corsRegistry) {
		corsRegistry.addMapping("/**")
		.allowedMethods("*")
		.allowedOrigins("http://localhost:4200")
		.allowedHeaders("*")
		.allowCredentials(false)
		.maxAge(-1);
	}
}
