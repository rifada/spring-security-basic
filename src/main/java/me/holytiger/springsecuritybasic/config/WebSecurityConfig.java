package me.holytiger.springsecuritybasic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService()
//    }

    /**
     * CSRF 설정을 disable 처리한다.
     * CORS 설정을 켠다.
     * 나머지 인증요청 중에 member관련 접근은 허용
     * api 관련 요청은 모두 인증이 있어야만 접근 가능
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //h2-console 구동을 위한 설정
        //h2-console 은 iframe을 사용하므로 해당 옵션을 disable처리
        http.headers()
                .frameOptions()
                .disable();

        http.csrf().disable()
                .cors()
                .and()
                .authorizeRequests()
                .antMatchers("/member/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll();
    }


    /**
     * spring 5.0 이상에서 password encoder가 default이므로
     * BCryptPasswordEncoder 를 default 인코더로 설정하여
     * Bean 으로 등록하여 DI 받을 수 있도록 한다
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
