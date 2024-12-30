package com.springboot.biz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//@Configuration 애너테이션은 해당 클래스가 스프링 컨테이너에 의해 
//설정(bean 정의) 클래스임을 나타냅니다.
@Configuration

//@EnableWebSecurity 애너테이션은 스프링 시큐리티의 웹 보안 기능을 활성화합니다.
//스프링 부트 프로젝트에서 보안을 구성할 수 있게 해줍니다.
@EnableMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfig {

 // SecurityFilterChain: 필터 체인을 정의하여 HTTP 요청에 대한 보안 설정을 구성합니다.
 // 스프링 시큐리티 5.x부터는 SecurityFilterChain을 사용해 설정하는 것이 권장됩니다.
 @Bean
 SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
     // HttpSecurity 객체를 사용해 보안 규칙을 설정합니다.
     http.authorizeHttpRequests( 
         // authorizeHttpRequests는 HTTP 요청의 접근 권한을 설정합니다.
         (authorizeHttpRequests) -> authorizeHttpRequests
             // AntPathRequestMatcher를 사용해 특정 경로에 대한 접근 권한을 설정합니다.
             // requestMatchers("/**")는 모든 경로에 대해 접근을 허용합니다.
             .requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
     		.formLogin((formLogin)->formLogin.loginPage("/user/login").defaultSuccessUrl("/"))
     		
     		.logout((logout)->logout.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
     				.logoutSuccessUrl("/").invalidateHttpSession(true));

     // 설정이 완료된 HttpSecurity 객체를 필터 체인으로 반환합니다.
     return http.build();
 }
 
//@Bean 어노테이션은 Spring 컨텍스트에서 해당 메서드의 반환값을 Bean으로 등록합니다.
@Bean
//PasswordEncoder Bean을 정의합니다. 
//Spring Security에서 비밀번호를 암호화할 때 사용하는 BCryptPasswordEncoder를 반환합니다.
//BCrypt는 암호화된 비밀번호를 안전하게 저장하고 검증하는 데 널리 사용되는 알고리즘입니다.
PasswordEncoder passwordEncoder() {
  return new BCryptPasswordEncoder();
}

@Bean
//AuthenticationManager Bean을 정의합니다.
//Spring Security의 인증 메커니즘을 관리하는 AuthenticationManager를 반환합니다.
//AuthenticationConfiguration 객체를 통해 기존의 Security 설정을 기반으로 AuthenticationManager를 가져옵니다.
//이 메서드는 사용자 인증 요청을 처리하기 위한 핵심 컴포넌트를 생성합니다.
AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
  return authenticationConfiguration.getAuthenticationManager();
}


}
