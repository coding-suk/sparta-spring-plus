package org.example.expert.config;

import lombok.RequiredArgsConstructor;
import org.example.expert.domain.user.entity.CustomUserDetails;
import org.example.expert.domain.user.service.CustomUserDetailsService;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class FilterConfig {

    private final JwtUtil jwtUtil;
    private final CustomUserDetailsService customUserDetailsService;

    @Bean
    public FilterRegistrationBean<JwtFilter> JwtAuthenticationFilter() {
        FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new JwtFilter(jwtUtil, customUserDetailsService));
        registrationBean.addUrlPatterns("/*"); // 필터를 적용할 URL 패턴을 지정합니다.

        return registrationBean;
    }
}
