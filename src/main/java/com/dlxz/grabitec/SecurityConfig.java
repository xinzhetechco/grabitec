package com.dlxz.grabitec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // 关闭 CSRF（前后端分离必须）
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/adminlte/login", "/adminlte/register","adminlte/index", "/**/*.js", "/**/*.css","/**/*.png","/favicon.ico")
                        .permitAll() // 注册接口允许访问
                        .anyRequest().authenticated() // 其他接口需要 session 登录
                )
                // 2. 登录配置
                .formLogin(form -> form
                        .loginPage("/adminlte/login")               // 自定义登录页面的访问路径 (Controller 映射)
                        .loginProcessingUrl("/doLogin")    // 登录表单提交到的 URL (Thymeleaf 页面中 action 的值)
                        .defaultSuccessUrl("/adminlte/index", true) // 登录成功后跳转的页面
                        .failureUrl("/login?error=true")   // 登录失败跳转的页面
                        .permitAll()
                )
                // 3. 注销配置
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout=true")
                        .permitAll()
                )
                .httpBasic(AbstractHttpConfigurer::disable);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
