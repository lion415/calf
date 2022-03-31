package com.wanda.fuyao.calf.base.security.config;

import com.wanda.fuyao.calf.base.security.filter.JwtAnthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @PackName: com.wanda.fuyao.calf.base.security.config
 * @ClassName: SecurityConfig
 * @Description: Spring Security配置类
 * @User: Lion
 * @Date: 2022/03/04  10:56
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

    @Autowired
    private JwtAnthenticationTokenFilter jwtAnthenticationTokenFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                //关闭csrf
                .csrf().disable()
                //不通过Session获取SecurityContext
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                //对于登陆接口，可以匿名访问
                .antMatchers("/wx/user/*/wxLogin","/wx/cp/contact/*/*","/pc/user/login").anonymous()
                //除了上面的请求，其他需要鉴权认证
                .anyRequest().authenticated();


        http.addFilterBefore(jwtAnthenticationTokenFilter,UsernamePasswordAuthenticationFilter.class);
//        http.addFilterAt(wxMiniAppLoginAuthenticationTokenFilter(),UsernamePasswordAuthenticationFilter.class);
    }
}
