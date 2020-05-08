package com.ts.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName SecurityConfig
 * @Description TODO
 * @Author 86175
 * @Date 2020/5/7 9:03
 * @Params TODO
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //下面这两行配置表示在内存中配置了两个用户
        auth.inMemoryAuthentication()
                .withUser("javaboy").roles("admin").password("$2a$10$OR3VSksVAmCzc.7WeaRPR.t0wyCsIj24k0Bne8iKWV1o.V9wsP8Xe")
                .and()
                .withUser("lisi").roles("user").password("$2a$10$p1H8iWa8I4.CA.7Z8bwLjes91ZpY.rYREGHQEInNtAp4NzL6PLKxi");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
