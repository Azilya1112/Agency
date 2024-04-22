package com.example.agency.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
        registry.addResourceHandler("/assets_admin/**").addResourceLocations("classpath:/assets_admin/");
        registry.addResourceHandler("/examples/**").addResourceLocations("classpath:/examples/");
        registry.addResourceHandler("/forms/**").addResourceLocations("classpath:/forms/");
        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");

    }
}