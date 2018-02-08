package com.miduodai.loanService.configure;

import com.miduodai.loanService.interceptor.AuthorizationInterceptor;
import com.miduodai.loanService.interceptor.CurrentUserMethodArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @Author: Kane
 * @Description:
 * @Date: Create in 下午9:30 18-1-25
 */

@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter{

    @Bean
    public AuthorizationInterceptor authorizationInterceptor () {
        return new AuthorizationInterceptor();
    }

    @Bean
    public CurrentUserMethodArgumentResolver currentUserMethodArgumentResolver () {
        return new CurrentUserMethodArgumentResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationInterceptor()).addPathPatterns("/**");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(currentUserMethodArgumentResolver());
    }
}
