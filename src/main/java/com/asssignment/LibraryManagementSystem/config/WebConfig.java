package com.asssignment.LibraryManagementSystem.config;

import com.asssignment.LibraryManagementSystem.service.WebpackConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import java.util.Arrays;
import java.util.stream.Collectors;

@Configuration
public class WebConfig {

    @Bean
    public WebpackConfig webpackConfig() throws Exception {
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();

        Resource[] jsResources = resourcePatternResolver.getResources("static/js/*.js");

        return new WebpackConfig(
                Arrays.stream(jsResources)
                        .map(resource -> "js/" + resource.getFilename())
                        .collect(Collectors.toList()));
    }
}