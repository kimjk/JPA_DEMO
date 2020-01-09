package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/**
 * mvc config
 *
 * @author : jkkim
 */
@Configuration
@ComponentScan(basePackages = {"com.example.demo"}
        , useDefaultFilters = false
        , includeFilters = {@ComponentScan.Filter(value = {Controller.class, ControllerAdvice.class})})
@EnableAspectJAutoProxy
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * tiles config
     *
     * @return
     */
    @Bean
    TilesConfigurer tilesConfigurer() {
        final TilesConfigurer configurer = new TilesConfigurer();
        configurer.setDefinitions(new String[]{"/WEB-INF/tiles/tiles.xml"});
        configurer.setCheckRefresh(true);
        return configurer;
    }

    /**
     * tiles view
     *
     * @return
     */
    @Bean
    TilesViewResolver tilesViewResolver() {
        final TilesViewResolver tilesViewResolver = new TilesViewResolver();
        tilesViewResolver.setViewClass(TilesView.class);
        return tilesViewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("/static/")
                .setCachePeriod(86400);
        //.setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS));
    }

}
