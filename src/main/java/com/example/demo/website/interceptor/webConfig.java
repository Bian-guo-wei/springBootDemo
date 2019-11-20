package com.example.demo.website.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2019/11/8.
 */
@Configuration
public class webConfig implements WebMvcConfigurer {
    /**
     * 添加类型转换器和格式化器
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
//        registry.addFormatterForFieldType(LocalDate.class, new USLocalDateFormatter());
    }

    /**
     * 跨域支持
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .maxAge(3600 * 24);
    }

    /**
     * 添加静态资源--过滤swagger-api (开源的在线API文档)
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //过滤swagger
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//
//        registry.addResourceHandler("/swagger-resources/**")
//                .addResourceLocations("classpath:/META-INF/resources/swagger-resources/");
//
//        registry.addResourceHandler("/swagger/**")
//                .addResourceLocations("classpath:/META-INF/resources/swagger*");
//
//        registry.addResourceHandler("/v2/api-docs/**")
//                .addResourceLocations("classpath:/META-INF/resources/v2/api-docs/");

    }

    /**
     * 配置消息转换器
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

    }

    //配置拦截路径
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new sspInterceptor())
                .addPathPatterns("/backendAdminController/**")
                .excludePathPatterns("/login")
                .excludePathPatterns("/backendAdminController/loginBackend");

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/login").setViewName("login/sspLogin");
    }

}
